package com.OOP.AutoserviceSpring.repository;

import com.OOP.AutoserviceSpring.exceptions.CustomerExceptions.CustomerNotFoundException;
import com.OOP.AutoserviceSpring.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Repository
public class InMemoryCustomer {
    private final List<Customer> CUSTOMERS = new ArrayList<>();


    public List<Customer> getCustomers() {
        return CUSTOMERS;
    }

    public Customer saveCustomer(Customer customer) {
        CUSTOMERS.add(customer);
        return customer;
    }

    public Customer findByName(String name) {
        return CUSTOMERS.stream()
                .filter(customer -> customer.getFirstname(). equals(name))
                .findFirst()
                .orElse(null);
    }

    public Customer updateCustomer(Customer customer){
        var customerToUpdate = IntStream.range(0, CUSTOMERS.size())
                .filter(i -> CUSTOMERS.get(i).getFirstname().equals(customer.getFirstname()))
                .findFirst()
                .orElse(-1);
        if (customerToUpdate > -1) {
            CUSTOMERS.set(customerToUpdate, customer);
        }
        return null;
    }

    public void deleteCustomerApplication(String name) {
        var customerToDelete = findByName(name);
        if(customerToDelete != null) {
            CUSTOMERS.remove(customerToDelete);
        }
        else{
            throw new CustomerNotFoundException(name);
        }
    }
}
