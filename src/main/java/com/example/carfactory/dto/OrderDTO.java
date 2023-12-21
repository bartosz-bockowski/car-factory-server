package com.example.carfactory.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDTO implements Serializable {

    private String brand;

    private String model;

    private String color;

    private String clientEmail;

}
