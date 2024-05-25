package com.OOP.AutoserviceSpring.Factories;

import com.OOP.AutoserviceSpring.model.Customer;

public interface CustomerFactory<T> {
    T createCustomer(String firstname, String lastname, String phone, String email, String timeofapplication, String additionalBenefit);

}
