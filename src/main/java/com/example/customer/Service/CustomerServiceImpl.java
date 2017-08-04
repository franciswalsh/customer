package com.example.customer.Service;

import com.example.customer.Repository.CustomerRepository;
import com.example.customer.Repository.CustomerRepositoryImpl;
import com.example.customer.model.Customer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by franciswalsh on 8/4/17.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    public CustomerServiceImpl(){

    }

    CustomerRepository customerRepository;

    private final String INSERT_SQL = "INSERT INTO customers (firstName, lastName, phone, email) VALUES (?,?,?,?)";
    @Transactional
    @Override
    public void addCustomer(Customer customer) {
        customerRepository.update(INSERT_SQL,
                customer.getFirstName(), customer.getLastName(),
                customer.getPhone(), customer.getEmail() );
    }

    private final String UPDATE_SQL = "UDPDATE customers SET firstName=?, lastName=?, phone=?, email=?, WHERE id=?";
    @Transactional
    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.update(UPDATE_SQL,
                customer.getFirstName(), customer.getLastName(),
                customer.getPhone(), customer.getEmail(), customer.getId() );
    }

    private final String SELECT_BY_ID_SQL = "SELECT * FROM customers WHERE id=?";
    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.queryForObject(SELECT_BY_ID_SQL, new CustomerRepositoryImpl.CustomerMapper(), id);
    }

    private final String SELECT_SQL = "SELECT * FROM customers";
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.query(SELECT_SQL, new CustomerRepositoryImpl.CustomerMapper());
    }

    private final String DELETE_SQL = "DELETE FROM customers WHERE id=?";
    @Transactional
    @Override
    public void deleteCustomer(int id) {
        customerRepository.update(DELETE_SQL, id);
    }

    private static class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setId(resultSet.getInt("id"));
            customer.setFirstName(resultSet.getString("firstName"));
            customer.setLastName(resultSet.getString("lastName"));
            customer.setPhone(resultSet.getString("phone"));
            customer.setEmail(resultSet.getString("email"));
            return customer;
        }
    }
}
