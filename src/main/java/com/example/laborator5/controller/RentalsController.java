package com.example.laborator5.controller;

import com.example.laborator5.entity.Rentals;
import com.example.laborator5.entity.Vehicles;
import com.example.laborator5.service.RentalsServices;
import com.example.laborator5.service.VehiclesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalsController {

    @Autowired
    private RentalsServices rentalsServices;


    @GetMapping("all")
    public List<Rentals> findAll() {
        return rentalsServices.findAll();
    }

    @PostMapping("/id")
    public void addRentals(@RequestBody Rentals rentals) {
        rentalsServices.addRental(rentals);
    }

    @GetMapping("{id}")
    public Rentals findByIdPath(@PathVariable int id) {
        return rentalsServices.findByIdPath(id);
    }

    @GetMapping("id")
    public Rentals findByIdParam(@RequestParam int id) {
        return rentalsServices.findByIdParam(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Rentals rentals) {
        rentalsServices.update(id, rentals);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        rentalsServices.delete(id);
    }
}
