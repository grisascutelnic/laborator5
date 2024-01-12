package com.example.laborator5.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Vehicles {
    private int vehicle_id;
    private String brand;
    private String model;
    private int year;
    private String number;
    private String status;
    private double cost;

    public Vehicles() {}
    public Vehicles(int vehicle_id, String brand, String model, int year, String number, String status, double cost) {
        this.vehicle_id = vehicle_id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.number = number;
        this.status = status;
        this.cost = cost;
    }
}
