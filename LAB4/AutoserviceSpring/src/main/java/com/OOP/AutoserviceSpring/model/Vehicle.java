package com.OOP.AutoserviceSpring.model;

import jakarta.persistence. *;
import lombok. *;


@Data
@Entity
@Table (name = "Vehicles")
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String model;
    private String year;
    private String type;
}
