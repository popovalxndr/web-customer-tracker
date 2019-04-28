package com.popovalxndr.springhibernatedemo.service;

import com.popovalxndr.springhibernatedemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void addCustomer(Customer customer);
}
