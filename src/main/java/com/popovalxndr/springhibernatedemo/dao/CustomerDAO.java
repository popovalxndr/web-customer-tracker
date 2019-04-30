package com.popovalxndr.springhibernatedemo.dao;

import com.popovalxndr.springhibernatedemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public Customer getCustomer(int id);

    public void saveCustomer(Customer customer);

    public void deleteCustomer(int customerId);

    List<Customer> searchCustomers(String searchStr);
}
