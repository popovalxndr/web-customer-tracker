package com.popovalxndr.springhibernatedemo.dao;

import com.popovalxndr.springhibernatedemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


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
    public Customer getCustomer(int customerId) {

        Session sess = sessionFactory.getCurrentSession();

        Customer customer = sess.get(Customer.class, customerId);

        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {

        Session sess = sessionFactory.getCurrentSession();

        sess.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(int customerId) {

        Session sess = sessionFactory.getCurrentSession();

        sess.createQuery("delete from Customer where id = :customerId")
                .setParameter("customerId", customerId)
                .executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchStr) {

        Session sess = sessionFactory.getCurrentSession();

        List<Customer> customers =
                sess.createQuery("from Customer " +
                "where lower(firstName) like :searchStr or lower(lastName) like :searchStr")
                .setParameter("searchStr", "%" + searchStr.toLowerCase() + "%")
                .getResultList();

        return customers;
    }

}

