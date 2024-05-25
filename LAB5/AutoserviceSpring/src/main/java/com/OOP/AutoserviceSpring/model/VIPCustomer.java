package com.OOP.AutoserviceSpring.model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@DiscriminatorValue("VIP")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class VIPCustomer extends Customer{
    private String discount;

    public VIPCustomer(String firstname, String lastname, String phone, String email, String timeofapplication, String discount) {
        super(firstname, lastname, phone, email, timeofapplication , discount , "0");
        this.discount = discount;
    }

    public String getAdditionalBenefit() {
        return discount;
    }
}
