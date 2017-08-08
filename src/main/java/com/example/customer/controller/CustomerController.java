package com.example.customer.controller;

import com.example.customer.Service.CustomerServiceImpl;
import com.example.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by franciswalsh on 8/8/17.
 */

@Controller
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerDatabase;



    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    public String getCustomers(Model model){
        List<Customer> customers = customerDatabase.getAllCustomers();
        model.addAttribute("customers", customers);
        return "viewAllCustomers";
    }

    @RequestMapping(path = "/addCustomer", method = RequestMethod.GET)
    public String addCustomerPage(Model model){
        return "addCustomer";
    }

    @RequestMapping(path = "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(Customer customer, Model model){
        customerDatabase.addCustomer(customer);
        List<Customer> customers = customerDatabase.getAllCustomers();
        model.addAttribute("customers", customers);
        return "viewAllCustomers";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String loginPage(Model model){
        return "login";
    }

    @RequestMapping("/loggedout")
    String logout(Model model) {
        return "loggedout";
    }

}
