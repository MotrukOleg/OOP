package com.OOP.AutoserviceSpring.service.impl;

import com.OOP.AutoserviceSpring.Factories.FactoriesImp.RegularCustomerFactory;
import com.OOP.AutoserviceSpring.Factories.FactoriesImp.VIPCustomerFactory;
import com.OOP.AutoserviceSpring.model.Customer;
import com.OOP.AutoserviceSpring.model.RegularCustomer;
import com.OOP.AutoserviceSpring.model.VIPCustomer;
import com.OOP.AutoserviceSpring.repository.InMemoryCustomer;
import com.OOP.AutoserviceSpring.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryCustomerServiceImpl implements CustomerService {
    private final InMemoryCustomer repository;
    private final RegularCustomerFactory RegularCustomerFactory;
    private final VIPCustomerFactory VIPCustomerFactory;


    @Override
    public List<Customer> getCustomers() {
        return repository.getCustomers();
    }


    @Override
    public List<RegularCustomer> getRegularCustomers() {
        return repository.getRegularCustomers();
    }

    @Override
    public List<VIPCustomer> getVIPCustomers() {
        return repository.getVIPCustomers();
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

    @Override
    public VIPCustomer createVIPCustomer(String firstname, String lastname, String phone, String email, String timeofapplication, String additionalBenefit) {
        VIPCustomer vipCustomer = VIPCustomerFactory.createCustomer(firstname, lastname, phone, email, timeofapplication, additionalBenefit);
        return (VIPCustomer) saveCustomer(vipCustomer);
    }

    @Override
    public RegularCustomer createRegularCustomer(String firstname, String lastname, String phone, String email, String timeofapplication, String discountRate) {
        RegularCustomer regularCustomer = RegularCustomerFactory.createCustomer(firstname, lastname, phone, email, timeofapplication, discountRate);
        return (RegularCustomer) saveCustomer(regularCustomer);
    }
}