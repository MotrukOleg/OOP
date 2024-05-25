package com.OOP.AutoserviceSpring.repository;

import com.OOP.AutoserviceSpring.exceptions.CustomerExceptions.CustomerNotFoundException;
import com.OOP.AutoserviceSpring.model.Customer;
import com.OOP.AutoserviceSpring.model.RegularCustomer;
import com.OOP.AutoserviceSpring.model.VIPCustomer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Repository
public class InMemoryCustomer {
    private final List<Customer> CUSTOMERS = new ArrayList<>();
    private final List<RegularCustomer> REGULARCUSTOMERS = new ArrayList<>();
    private final List<VIPCustomer> VIPCUSTOMERS = new ArrayList<>();


    public List<Customer> getCustomers() {
        return CUSTOMERS;
    }

    public List<RegularCustomer> getRegularCustomers() {
        return REGULARCUSTOMERS;
    }

    public List<VIPCustomer> getVIPCustomers() {
        return VIPCUSTOMERS;
    }

    public RegularCustomer saveCustomer(RegularCustomer customer) {
        CUSTOMERS.add(customer);
        return customer;
    }

    public VIPCustomer saveCustomer(VIPCustomer customer) {
        CUSTOMERS.add(customer);
        return customer;
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

    public RegularCustomer createRegularCustomer(RegularCustomer customer) {
        REGULARCUSTOMERS.add(customer);
        return customer;
    }

    public VIPCustomer createVIPCustomer(VIPCustomer customer) {
        VIPCUSTOMERS.add(customer);
        return customer;
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

    public RegularCustomer updateRegularCustomer(RegularCustomer customer){
        var customerToUpdate = IntStream.range(0, REGULARCUSTOMERS.size())
                .filter(i -> REGULARCUSTOMERS.get(i).getFirstname().equals(customer.getFirstname()))
                .findFirst()
                .orElse(-1);
        if (customerToUpdate > -1) {
            REGULARCUSTOMERS.set(customerToUpdate, customer);
        }
        return null;
    }

    public VIPCustomer updateVIPCustomer(VIPCustomer customer){
        var customerToUpdate = IntStream.range(0, VIPCUSTOMERS.size())
                .filter(i -> VIPCUSTOMERS.get(i).getFirstname().equals(customer.getFirstname()))
                .findFirst()
                .orElse(-1);
        if (customerToUpdate > -1) {
            VIPCUSTOMERS.set(customerToUpdate, customer);
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

    public void deleteRegularCustomerApplication(String name) {
        var customerToDelete = findByName(name);
        if(customerToDelete != null) {
            REGULARCUSTOMERS.remove(customerToDelete);
        }
        else{
            throw new CustomerNotFoundException(name);
        }
    }

    public void deleteVIPCustomerApplication(String name) {
        var customerToDelete = findByName(name);
        if(customerToDelete != null) {
            VIPCUSTOMERS.remove(customerToDelete);
        }
        else{
            throw new CustomerNotFoundException(name);
        }
    }
}