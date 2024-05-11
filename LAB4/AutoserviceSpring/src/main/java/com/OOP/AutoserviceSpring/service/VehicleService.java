package com.OOP.AutoserviceSpring.service;

import com.OOP.AutoserviceSpring.model.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getVehicles();
    Vehicle saveVehicle(Vehicle vehicle);
    Vehicle findByBrand(String brand);
    Vehicle updateVehicle(Vehicle vehicle);
    void deleteVehicle(String brand);
}
