package com.OOP.AutoserviceSpring.service.impl;


import com.OOP.AutoserviceSpring.model.Customer;
import com.OOP.AutoserviceSpring.repository.CustomerRepository;
import com.OOP.AutoserviceSpring.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    @Override
    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer findByName(String name) {
        return repository.findCustomerByFirstname(name);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    @Transactional
    public void deleteCustomerApplication(String name) {
        repository.deleteByFirstname(name);
    }



}
