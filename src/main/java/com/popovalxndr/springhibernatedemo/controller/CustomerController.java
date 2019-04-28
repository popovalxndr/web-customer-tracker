package com.popovalxndr.springhibernatedemo.controller;

import com.popovalxndr.springhibernatedemo.dao.CustomerDAO;
import com.popovalxndr.springhibernatedemo.entity.Customer;
import com.popovalxndr.springhibernatedemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {

        List<Customer> customers = customerService.getCustomers();

        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/addCustomerForm")
    public String addCustomerDialog(Model model) {

        model.addAttribute("customer", new Customer());

        return "add-customer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.addCustomer(customer);

        return "redirect:/customer/list";
    }
}
