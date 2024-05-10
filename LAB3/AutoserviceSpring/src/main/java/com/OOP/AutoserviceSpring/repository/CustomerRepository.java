package com.OOP.AutoserviceSpring.repository;


import com.OOP.AutoserviceSpring.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    void deleteByFirstname(String name);

    Customer findCustomerByFirstname(String name);
}
