package com.popovalxndr.springhibernatedemo.dao;

import com.popovalxndr.springhibernatedemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session sess = sessionFactory.getCurrentSession();

        List<Customer> customers = sess.createQuery("from Customer order by lastName").getResultList();

        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {

        Session sess = sessionFactory.getCurrentSession();

        sess.save(customer);
    }
}

