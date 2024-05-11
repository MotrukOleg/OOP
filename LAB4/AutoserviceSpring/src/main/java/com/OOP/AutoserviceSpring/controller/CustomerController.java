package com.OOP.AutoserviceSpring.controller;
import com.OOP.AutoserviceSpring.exceptions.CustomerExceptions.CustomerNotFoundException;
import com.OOP.AutoserviceSpring.model.Customer;
import com.OOP.AutoserviceSpring.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/autoservice/customer")
@AllArgsConstructor

public class CustomerController {

    private final CustomerService service;
    private static final Logger logger = Logger.getLogger(CustomerController.class.getName());

    @GetMapping
    public List<Customer> getCustomers(){
        //todo
        return service.getCustomers();
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody Customer customer){
        service.saveCustomer(customer);
        return "Application Saved Successfully";
    }

    @GetMapping({"/{name}"})
    public Customer findByName(@PathVariable String name) {
        var customer = service.findByName(name);
        if (customer == null) {
            throw new CustomerNotFoundException(name);
        }
        return customer;
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.updateCustomer(customer);
    }

    @DeleteMapping({"/delete_customer_application/{name}"})
    public void DeleteCustomerApplication(@PathVariable String name) {

        service.deleteCustomerApplication(name);
        logger.info("Customer Application Deleted Successfully");
    }
}
