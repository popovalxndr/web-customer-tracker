package com.popovalxndr.springhibernatedemo.dao;

import com.popovalxndr.springhibernatedemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void addCustomer(Customer customer);
}
