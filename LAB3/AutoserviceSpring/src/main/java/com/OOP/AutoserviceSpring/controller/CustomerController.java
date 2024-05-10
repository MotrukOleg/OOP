package com.OOP.AutoserviceSpring.controller;
import com.OOP.AutoserviceSpring.exceptions.CustomerNotFoundException;
import com.OOP.AutoserviceSpring.model.Customer;
import com.OOP.AutoserviceSpring.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/autoservice/customer")
@AllArgsConstructor

public class CustomerController {

    private final CustomerService service;

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
            throw new CustomerNotFoundException("Customer with name " + name + " not found");
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
    }
}
