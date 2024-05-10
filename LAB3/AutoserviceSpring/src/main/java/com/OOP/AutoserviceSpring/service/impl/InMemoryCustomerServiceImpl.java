package com.OOP.AutoserviceSpring.service.impl;

import com.OOP.AutoserviceSpring.model.Customer;
import com.OOP.AutoserviceSpring.repository.InMemoryCustomer;
import com.OOP.AutoserviceSpring.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryCustomerServiceImpl implements CustomerService {
    private final InMemoryCustomer repository;
    @Override
    public List<Customer> getCustomers() {
        return repository.getCustomers();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.saveCustomer(customer);
    }

    @Override
    public Customer findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomerApplication(String name) {
        repository.deleteCustomerApplication(name);
    }
}
