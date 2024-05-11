package com.OOP.AutoserviceSpring.controller;


import com.OOP.AutoserviceSpring.exceptions.VehicleException.VehicleNotFound;
import com.OOP.AutoserviceSpring.model.Vehicle;
import com.OOP.AutoserviceSpring.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/autoservice/vehicle")
@AllArgsConstructor
public class VehicleController {

    private final VehicleService service;
    private static final Logger logger = Logger.getLogger(VehicleController.class.getName());

    @GetMapping
    public List<Vehicle> getVehicles(){
        //todo
        return service.getVehicles();
    }

    @PostMapping("/save")
    public  String saveVehicle(@RequestBody Vehicle vehicle){
        service.saveVehicle(vehicle);
        return "Vehicle Saved Successfully";
    }

    @GetMapping("/{brand}")
    public Vehicle findByBrand(@PathVariable String brand){
        var vehicleToFind = service.findByBrand(brand);
        if(brand == null){
            throw new VehicleNotFound(brand);
        }
        return vehicleToFind;
    }


    @PutMapping("/update")
    public  Vehicle updateVehicle(@RequestBody Vehicle vehicle){
        return service.updateVehicle(vehicle);
    }

    @DeleteMapping("/delete_vehicle/{name}")
    public String deleteVehicle(@PathVariable String name){
        service.deleteVehicle(name);
        logger.info("Vehicle Deleted Successfully");
        return "Vehicle Deleted Successfully";
    }

}
