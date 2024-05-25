package com.OOP.AutoserviceSpring.Factories.FactoriesImp;

import com.OOP.AutoserviceSpring.Factories.CustomerFactory;
import com.OOP.AutoserviceSpring.model.Customer;
import com.OOP.AutoserviceSpring.model.VIPCustomer;
import org.springframework.stereotype.Component;

@Component
public class VIPCustomerFactory implements CustomerFactory<VIPCustomer> {
    @Override
    public VIPCustomer createCustomer(String firstname, String lastname, String phone, String email, String timeofapplication, String additionalBenefit) {
        return new VIPCustomer(firstname, lastname, phone, email, timeofapplication, additionalBenefit);
    }

}
