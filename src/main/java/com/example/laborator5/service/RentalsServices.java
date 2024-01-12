package com.example.laborator5.service;

import com.example.laborator5.entity.Rentals;
import com.example.laborator5.entity.Vehicles;
import com.example.laborator5.exceptions.AlreadyExistError;
import com.example.laborator5.exceptions.NotFoundError;
import com.example.laborator5.repository.RentalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalsServices {

    @Autowired
    private RentalsRepository rentalsRepository;

    public List<Rentals> findAll() {
        return rentalsRepository.findAll();
    }

    public Rentals findByIdPath(int id) {
        if(!rentalsRepository.existById(id)) {
            throw new NotFoundError("Not found a rental with id: " + id);
        }

        return rentalsRepository.findByIdPath(id);
    }

    public Rentals findByIdParam(int id) {
        return rentalsRepository.findByIdParam(id);
    }
    public void addRental(Rentals rentals) {
        if (rentalsRepository.alreadyExistId(rentals.getRental_id())) {
            throw new AlreadyExistError("Already exist a rental with id: " + rentals.getRental_id());
        }
        rentalsRepository.addRental(rentals);
    }
    public void update(int id, Rentals rentals) {
        rentalsRepository.update(id, rentals);
    }

    public void delete(int id) {
        rentalsRepository.delete(id);
    }
}
