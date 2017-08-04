package com.example.customer.model;

/**
 * Created by franciswalsh on 8/4/17.
 */
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private int customer_pkey;

    public Customer(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomer_pkey() {
        return customer_pkey;
    }

    public void setCustomer_pkey(int customer_pkey) {
        this.customer_pkey = customer_pkey;
    }
}
