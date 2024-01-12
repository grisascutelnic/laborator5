package com.example.laborator5.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Clients {
    private int client_id;
    private String firstname;
    private String lastname;
    private String dob;
    private String address;
    private String phone;

    public Clients() {}

    public Clients(int client_id, String firstname, String lastname, String dob, String address, String phone) {
        this.client_id = client_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
    }
}
