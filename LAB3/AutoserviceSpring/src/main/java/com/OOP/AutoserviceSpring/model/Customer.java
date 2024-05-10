package com.OOP.AutoserviceSpring.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Entity
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
}
