package com.OOP.AutoserviceSpring.repository;

import com.OOP.AutoserviceSpring.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    void deleteByBrand(String brand);

    Vehicle findVehicleByBrand(String brand);

}
