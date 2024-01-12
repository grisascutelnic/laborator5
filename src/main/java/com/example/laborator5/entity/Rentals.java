package com.example.laborator5.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Rentals {
    private int rental_id;
    private int vehicle_id;
    private int client_id;
    private String startdate;
    private String enddate;
    private double cost;

    public Rentals() {}

    public Rentals(int rental_id, int vehicle_id, int client_id, String startdate, String enddate, double cost) {
        this.rental_id = rental_id;
        this.vehicle_id = vehicle_id;
        this.client_id = client_id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.cost = cost;
    }
}
