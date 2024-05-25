package com.OOP.AutoserviceSpring.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@DiscriminatorValue("RegularCustomer")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class RegularCustomer extends Customer{
    private String loyaltyPoints;
    public RegularCustomer(String firstname, String lastname, String phone, String email, String timeofapplication, String loyaltyPoints) {
        super(firstname, lastname, phone, email, timeofapplication , "0", loyaltyPoints);
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getDiscountRate() {
        return loyaltyPoints;
    }
}
