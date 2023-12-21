package com.example.carfactory.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity(name = "car_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "brand of the vehicle cannot be empty")
    private String brand;

    @NotEmpty(message = "model of the vehicle cannot be empty")
    private String model;

    @NotEmpty(message = "color of the vehicle cannot be empty")
    private String color;

    @NotEmpty(message = "client's email address cannot be empty")
    private String clientEmail;

}
