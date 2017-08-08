package com.example.customer.Service;

import com.example.customer.Repository.CustomerRepository;
import com.example.customer.model.Customer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by franciswalsh on 8/7/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("setting up test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearing down test");
    }
    @Autowired
    CustomerServiceImpl customerRepository;

    @Transactional
    @Test
    public void testAddGet(){
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        customer1.setFirstName("Bill");
        customer2.setFirstName("Joe");
        customer1.setLastName("James");
        customer2.setLastName("Johnson");
        customer1.setEmail("alkjdf@gmail.com");
        customer2.setEmail("zmcnv@yahoo.com");
        customer1.setPhone("1234567890");
        customer2.setPhone("0987654321");

        customerRepository.addCustomer(customer1);
        customerRepository.addCustomer(customer2);

        List<Customer> customers = customerRepository.getAllCustomers();

        Customer customer3 = customers.get(0);

        Assert.assertNotNull(customer3);
        Assert.assertEquals(customer1.getFirstName(), customer3.getFirstName());

    }
    @Transactional
    @Test
    public void testDelete(){
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        customer1.setFirstName("Bill");
        customer2.setFirstName("Joe");
        customer1.setLastName("James");
        customer2.setLastName("Johnson");
        customer1.setEmail("alkjdf@gmail.com");
        customer2.setEmail("zmcnv@yahoo.com");
        customer1.setPhone("1234567890");
        customer2.setPhone("0987654321");

        customerRepository.addCustomer(customer1);
        customerRepository.addCustomer(customer2);


        customerRepository.deleteCustomer(customer2.getId());

        List<Customer> customers = customerRepository.getAllCustomers();
        System.out.println(customers);

        Customer customer3 = customers.get(1);

        Assert.assertNull(customer3.getFirstName());

    }

}