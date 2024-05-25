package com.OOP.AutoserviceSpring.service.impl;


import com.OOP.AutoserviceSpring.model.Vehicle;
import com.OOP.AutoserviceSpring.repository.VehicleRepository;
import com.OOP.AutoserviceSpring.service.VehicleService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository repository;

    @Override
    public List<Vehicle> getVehicles() {
        return repository.findAll();
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public Vehicle findByBrand(String brand) {
        return repository.findVehicleByBrand(brand);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    @Transactional
    public void deleteVehicle(String brand) {
        repository.deleteByBrand(brand);
    }
}
