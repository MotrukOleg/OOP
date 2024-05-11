package com.OOP.AutoserviceSpring.exceptions.CustomerExceptions;

public class CustomerNotFoundException extends InternalError{
    public CustomerNotFoundException(String name) {
        super(String.format("Customer with name " + name + " not found"));
    }
}



