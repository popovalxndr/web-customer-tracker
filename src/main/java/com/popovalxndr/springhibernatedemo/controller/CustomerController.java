package com.popovalxndr.springhibernatedemo.controller;

import com.popovalxndr.springhibernatedemo.dao.CustomerDAO;
import com.popovalxndr.springhibernatedemo.entity.Customer;
import com.popovalxndr.springhibernatedemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

        return "save-customer";
    }

    @GetMapping("/updateCustomerForm")
    public String updateCustomerDialog(@RequestParam int customerId, Model model) {

        Customer customer = customerService.getCustomer(customerId);

        model.addAttribute("customer", customer);

        return "save-customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam int customerId) {

        customerService.deleteCustomer(customerId);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String deleteCustomer(@RequestParam String searchStr, Model model) {

        List<Customer> customers = customerService.searchCustomers(searchStr);

        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
