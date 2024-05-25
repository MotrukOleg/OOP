package com.OOP.AutoserviceSpring.service;


import com.OOP.AutoserviceSpring.Factories.FactoriesImp.RegularCustomerFactory;
import com.OOP.AutoserviceSpring.model.Customer;
import com.OOP.AutoserviceSpring.model.RegularCustomer;
import com.OOP.AutoserviceSpring.model.VIPCustomer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    List<RegularCustomer> getRegularCustomers();

    List<VIPCustomer> getVIPCustomers();

    Customer saveCustomer (Customer customer);
    Customer findByName(String name);
    Customer updateCustomer(Customer customer);

    void deleteCustomerApplication(String name);

    VIPCustomer createVIPCustomer(String firstname, String lastname, String phone, String email, String timeofapplication, String additionalBenefit);
    RegularCustomer createRegularCustomer(String firstname, String lastname, String phone, String email, String timeofapplication, String discountRate);
}