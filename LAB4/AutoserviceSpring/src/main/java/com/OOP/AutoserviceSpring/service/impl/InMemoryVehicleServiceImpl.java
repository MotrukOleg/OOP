package com.OOP.AutoserviceSpring.service.impl;

import com.OOP.AutoserviceSpring.model.Vehicle;
import com.OOP.AutoserviceSpring.repository.InMemoryVehicle;
import com.OOP.AutoserviceSpring.repository.VehicleRepository;
import com.OOP.AutoserviceSpring.service.VehicleService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryVehicleServiceImpl implements VehicleService {
    private final InMemoryVehicle repository;

    @Override
    public List<Vehicle> getVehicles() {return repository.getVehicles();}

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {return repository.saveVehicle(vehicle);}

    @Override
    public Vehicle findByBrand(String brand) {
        return repository.findByBrand(brand);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {return repository.updateVehicle(vehicle);}

    @Override
    public void deleteVehicle(String brand) {
        repository.deleteVehicle(brand);
    }
}
