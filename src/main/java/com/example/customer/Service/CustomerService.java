package com.example.customer.Service;

import com.example.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by franciswalsh on 8/4/17.
 */
public interface CustomerService {

    Customer addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
    void deleteCustomer(int id);
}
