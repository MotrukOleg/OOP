package com.OOP.AutoserviceSpring.service.impl;


import com.OOP.AutoserviceSpring.Factories.CustomerFactory;
import com.OOP.AutoserviceSpring.Factories.FactoriesImp.RegularCustomerFactory;
import com.OOP.AutoserviceSpring.Factories.FactoriesImp.VIPCustomerFactory;
import com.OOP.AutoserviceSpring.model.Customer;
import com.OOP.AutoserviceSpring.model.RegularCustomer;
import com.OOP.AutoserviceSpring.model.VIPCustomer;
import com.OOP.AutoserviceSpring.repository.CustomerRepository;
import com.OOP.AutoserviceSpring.repository.RegularCustomerRepository;
import com.OOP.AutoserviceSpring.repository.VIPCustomerRepository;
import com.OOP.AutoserviceSpring.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final RegularCustomerRepository repository1;
    private final VIPCustomerRepository repository2;

    @Override
    public List<Customer> getCustomers() {
        return repository.findAll();
    }


    public List<RegularCustomer> getRegularCustomers() {
        return repository1.findAll();
    }

    public List<VIPCustomer> getVIPCustomers() {
        return repository2.findAll();
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

    @Override
    public VIPCustomer createVIPCustomer(String firstname, String lastname, String phone, String email, String timeofapplication, String additionalBenefit) {
        VIPCustomerFactory vipCustomerFactory = new VIPCustomerFactory();
        VIPCustomer vipCustomer = vipCustomerFactory.createCustomer(firstname, lastname, phone, email, timeofapplication, additionalBenefit);
        return (VIPCustomer) saveCustomer(vipCustomer);
    }

    @Override
    public RegularCustomer createRegularCustomer(String firstname, String lastname, String phone, String email, String timeofapplication, String discountRate) {
        RegularCustomerFactory regularCustomerFactory = new RegularCustomerFactory();
        RegularCustomer regularCustomer = regularCustomerFactory.createCustomer(firstname, lastname, phone, email, timeofapplication, discountRate);
        return (RegularCustomer) saveCustomer(regularCustomer);
    }
}