package com.example.customer.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

import static javax.xml.ws.soap.AddressingFeature.ID;

/**
 * Created by franciswalsh on 8/4/17.
 */
@Entity
@Table(name = "customer")
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private int customer_pkey;

    public Customer(){

    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastname")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return getId() == customer.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
