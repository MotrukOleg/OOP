package com.OOP.AutoserviceSpring.exceptions;

public class CustomerNotFoundException extends InternalError{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}

