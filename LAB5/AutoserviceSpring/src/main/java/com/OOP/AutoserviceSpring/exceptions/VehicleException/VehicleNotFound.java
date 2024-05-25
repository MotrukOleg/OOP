package com.OOP.AutoserviceSpring.exceptions.VehicleException;

public class VehicleNotFound extends InternalError {
    public VehicleNotFound(String brand){
        super(String.format("Vehicle with brand " + brand + " Not found"));
    }
}
