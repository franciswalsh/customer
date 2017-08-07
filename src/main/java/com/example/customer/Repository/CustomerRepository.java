package com.example.customer.Repository;

import com.example.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by franciswalsh on 8/4/17.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}

