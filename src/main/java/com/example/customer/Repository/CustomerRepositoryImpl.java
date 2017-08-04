package com.example.customer.Repository;

import com.example.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by franciswalsh on 8/4/17.
 */

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl(){

    }

    private final String INSERT_SQL = "INSERT INTO customers (firstName, lastName, phone, email) VALUES (?,?,?,?)";
    @Override
    public void addCustomer(Customer customer) {
        jdbcTemplate.update(INSERT_SQL,
                            customer.getFirstName(), customer.getLastName(),
                            customer.getPhone(), customer.getEmail() );
    }

    private final String UPDATE_SQL = "UDPDATE customers SET firstName=?, lastName=?, phone=?, email=?, WHERE id=?";
    @Override
    public void updateCustomer(Customer customer) {
        jdbcTemplate.update(UPDATE_SQL,
                customer.getFirstName(), customer.getLastName(),
                customer.getPhone(), customer.getEmail(), customer.getId() );
    }

    private final String SELECT_BY_ID_SQL = "SELECT * FROM customers WHERE id=?";
    @Override
    public Customer getCustomerById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new CustomerMapper(), id);
    }

    private final String SELECT_SQL = "SELECT * FROM customers";
    @Override
    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query(SELECT_SQL, new CustomerMapper());
    }

    private final String DELETE_SQL = "DELETE FROM customers WHERE id=?";
    @Override
    public void deleteCustomer(int id) {
        jdbcTemplate.update(DELETE_SQL, id);
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
