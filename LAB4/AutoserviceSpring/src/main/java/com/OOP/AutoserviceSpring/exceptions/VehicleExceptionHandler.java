package com.OOP.AutoserviceSpring.exceptions;

import com.OOP.AutoserviceSpring.exceptions.CustomerExceptions.CustomerNotFoundException;
import com.OOP.AutoserviceSpring.exceptions.VehicleException.VehicleNotFound;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VehicleExceptionHandler {
    @ExceptionHandler(VehicleNotFound.class)
    public ResponseEntity<Object> handleVehicleNotFound(CustomerNotFoundException ex , HttpServletRequest request , HttpServletResponse response){
        if(ex != null){
            return new ResponseEntity<>(ex.getMessage() ,HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
