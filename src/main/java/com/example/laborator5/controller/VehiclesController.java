package com.example.laborator5.controller;

import com.example.laborator5.entity.Vehicles;
import com.example.laborator5.service.VehiclesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {
    @Autowired
    private VehiclesServices vehiclesServices;


    @GetMapping("")
    public List<Vehicles> findAll() {
        return vehiclesServices.findAll();
    }

    @PostMapping()
    public void addVehicle(@RequestBody Vehicles vehicles) {
        vehiclesServices.addVehicle(vehicles);
    }

    @PostMapping("/id")
    public void addVehicleId(@RequestBody Vehicles vehicles) {
        vehiclesServices.addVehicleId(vehicles);
    }

    @GetMapping("{id}")
    public Vehicles findByIdPath(@PathVariable int id) {
        return vehiclesServices.findByIdPath(id);
    }
    @GetMapping("id")
    public Vehicles findByIdParam(@RequestParam int id) {
        return vehiclesServices.findByIdParam(id);
    }
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Vehicles vehicles) {
        vehiclesServices.update(id, vehicles);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        vehiclesServices.delete(id);
    }
}
