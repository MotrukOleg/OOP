package com.OOP.AutoserviceSpring.repository;

import com.OOP.AutoserviceSpring.model.VIPCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VIPCustomerRepository extends JpaRepository<VIPCustomer, Long> {
    void deleteByFirstname(String name);
    VIPCustomer findCustomerByFirstname(String name);
}
