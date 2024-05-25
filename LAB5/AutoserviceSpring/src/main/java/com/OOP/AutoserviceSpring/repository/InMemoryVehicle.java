package com.OOP.AutoserviceSpring.repository;


import com.OOP.AutoserviceSpring.exceptions.VehicleException.VehicleNotFound;
import com.OOP.AutoserviceSpring.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryVehicle {

    private  final List<Vehicle> VEHICLES = new ArrayList<>();

    public List<Vehicle> getVehicles() {
        return VEHICLES;
    }

    public Vehicle saveVehicle(Vehicle vehicle){
        VEHICLES.add(vehicle);
        return vehicle;
    }

    public Vehicle findByBrand(String brand){
        return VEHICLES.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .findFirst()
                .orElse(null);
    }

    public  Vehicle updateVehicle(Vehicle vehicle){
        var vehicleToUpdate = IntStream.range(0, VEHICLES.size())
                .filter(v -> VEHICLES.get(v).getBrand().equals(vehicle.getBrand()))
                .findFirst()
                .orElse(-1);
        if(vehicleToUpdate > -1){
            VEHICLES.set(vehicleToUpdate, vehicle);
        }
        return null;
    }

    public void deleteVehicle(String brand){
        var vehicleToDelete = findByBrand(brand);
        if(vehicleToDelete != null){
            VEHICLES.remove(vehicleToDelete);
        }
        else{
            throw new VehicleNotFound(brand);
        }
    }
}
