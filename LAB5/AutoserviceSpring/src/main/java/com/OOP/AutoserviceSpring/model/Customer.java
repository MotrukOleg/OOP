package com.OOP.AutoserviceSpring.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table (name = "Customers")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String timeofapplication;
    private String additionalBenefit;
    private String loyaltyPoints;

    public Customer(String firstname, String lastname, String phone, String email, String timeofapplication , String additionalBenefit, String loyaltyPoints) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.timeofapplication = timeofapplication;
        this.additionalBenefit = additionalBenefit;
        this.loyaltyPoints = loyaltyPoints;
    }
}