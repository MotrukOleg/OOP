package com.OOP.AutoserviceSpring.Factories.FactoriesImp;

import com.OOP.AutoserviceSpring.Factories.CustomerFactory;
import com.OOP.AutoserviceSpring.model.Customer;
import com.OOP.AutoserviceSpring.model.RegularCustomer;
import org.springframework.stereotype.Component;

@Component
public class RegularCustomerFactory implements CustomerFactory<RegularCustomer> {
    @Override
    public RegularCustomer createCustomer(String firstname, String lastname, String phone, String email, String timeofapplication, String discountRate) {
        return new RegularCustomer(firstname, lastname, phone, email, timeofapplication, discountRate);
    }

}
