package com.OOP.AutoserviceSpring.controller;


import com.OOP.AutoserviceSpring.model.Vehicle;
import com.OOP.AutoserviceSpring.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/autoservice/vehicle")
@AllArgsConstructor
public class VehicleController {

    private final VehicleService service;

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
        return service.findByBrand(brand);
    }

    @PutMapping("/update")
    public  Vehicle updateVehicle(@RequestBody Vehicle vehicle){
        return service.updateVehicle(vehicle);
    }

    @DeleteMapping("/delete_vehicle/{name}")
    public void deleteVehicle(@PathVariable String name){
        service.deleteVehicle(name);
    }

}
