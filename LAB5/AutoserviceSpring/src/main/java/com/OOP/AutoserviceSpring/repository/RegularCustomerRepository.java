package com.OOP.AutoserviceSpring.repository;

import com.OOP.AutoserviceSpring.model.RegularCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegularCustomerRepository extends JpaRepository<RegularCustomer, Long>{
    void deleteByFirstname(String name);
    RegularCustomer findCustomerByFirstname(String name);
}
