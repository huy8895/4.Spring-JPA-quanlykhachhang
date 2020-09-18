package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ICustomerService;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    ICustomerService<Customer> customerService;

    @GetMapping
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("customers",customerList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        return new ModelAndView("/customer/create","customer",new Customer());
    }

    @PostMapping("/create")
    public String create(Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }

}

