package controller;

import model.Customer;
import model.CustomerForm;
import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ICustomerService;
import service.IProvinceService;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private Environment environment;
    @Autowired
    ICustomerService customerService;

    @Autowired
    IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping
    public String showList(){
        return "redirect:customers/find";
    }

    @GetMapping("/create")
    public ModelAndView showCreate(Model model) {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customerForm", new CustomerForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(CustomerForm customerForm) {

        MultipartFile multipartFile = customerForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String folderUpload = environment.getProperty("file_upload");
        String path = folderUpload + fileName;
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Customer customer = new Customer(customerForm.getFirstName(), customerForm.getLastName(), fileName);
        customer.setProvince(customerForm.getProvince());
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEdit(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/{id}/edit")
    public String edit(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDelete(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("/customer/delete");
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @PostMapping("/{id}/delete")
    public String delete(Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:/customers";
    }

    @GetMapping("/find")
    public ModelAndView findByName(@RequestParam("key") Optional<String> keyword,
                                   @RequestParam("page") Optional<Integer> page,
                                   Pageable pageable) {
        PageRequest pageRequest = new PageRequest(page.orElse(0), 5);
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        Page<Customer> customerList = customerService.findAllByFirstNameContaining(keyword.orElse(""), pageRequest);
        modelAndView.addObject("customers", customerList);
        modelAndView.addObject("keyword",keyword.orElse(""));
        return modelAndView;
    }
}

