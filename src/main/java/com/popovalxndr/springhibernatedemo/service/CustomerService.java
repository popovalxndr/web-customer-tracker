package com.popovalxndr.springhibernatedemo.service;

import com.popovalxndr.springhibernatedemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public Customer getCustomer(int customerId);

    public void saveCustomer(Customer customer);

    public void deleteCustomer(int customerId);

    List<Customer> searchCustomers(String searchStr);
}
