package com.example.customer.Repository;

import com.example.customer.model.Customer;

import java.util.List;

/**
 * Created by franciswalsh on 8/4/17.
 */
public interface CustomerRepository {

    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
    void deleteCustomer(int id);

}

