package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ICustomerService;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("customers",customerList);
        return modelAndView;
    }
}
