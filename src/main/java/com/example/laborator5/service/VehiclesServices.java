package com.example.laborator5.service;

import com.example.laborator5.entity.Vehicles;
import com.example.laborator5.exceptions.AlreadyExistError;
import com.example.laborator5.exceptions.NotFoundError;
import com.example.laborator5.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiclesServices {
    @Autowired
    private VehiclesRepository vehiclesRepository;


    public List<Vehicles> findAll() {
        return vehiclesRepository.findAll();
    }

    public Vehicles findByIdPath(int id) {
        if(!vehiclesRepository.existById(id)) {
            throw new NotFoundError("Not found a vehicle with id: " + id);
        }

        return vehiclesRepository.findByIdPath(id);
    }

    public Vehicles findByIdParam(int id) {
        return vehiclesRepository.findByIdParam(id);
    }
    public void addVehicle(Vehicles vehicles) {
        vehiclesRepository.addVehicle(vehicles);
    }
    public void addVehicleId(Vehicles vehicles) {
        if (vehiclesRepository.alreadyExistId(vehicles.getVehicle_id())) {
            throw new AlreadyExistError("Already exist a vehicle with id: " + vehicles.getVehicle_id());
        }
        vehiclesRepository.addVehicleId(vehicles);
    }
    public void update(int id, Vehicles vehicles) {
        vehiclesRepository.update(id, vehicles);
    }

    public void delete(int id) {
        vehiclesRepository.delete(id);
    }
}
