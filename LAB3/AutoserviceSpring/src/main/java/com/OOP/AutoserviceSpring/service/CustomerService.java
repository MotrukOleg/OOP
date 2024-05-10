package com.OOP.AutoserviceSpring.service;


import com.OOP.AutoserviceSpring.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();
    Customer saveCustomer (Customer customer);
    Customer findByName(String name);
    Customer updateCustomer(Customer customer);

    void deleteCustomerApplication(String name);
}
