package com.example.laborator5.service;

import com.example.laborator5.entity.Clients;
import com.example.laborator5.entity.Rentals;
import com.example.laborator5.exceptions.AlreadyExistError;
import com.example.laborator5.exceptions.NotFoundError;
import com.example.laborator5.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientsService {
    @Autowired
    private ClientsRepository clientsRepository;

    public List<Clients> findAll() {
        return clientsRepository.findAll();
    }

    public Clients findByIdPath(int id) {
        if(!clientsRepository.existById(id)) {
            throw new NotFoundError("Not found a rental with id: " + id);
        }

        return clientsRepository.findByIdPath(id);
    }

    public Clients findByIdParam(int id) {
        return clientsRepository.findByIdParam(id);
    }
    public void addClient(Clients clients) {
        if (clientsRepository.alreadyExistId(clients.getClient_id())) {
            throw new AlreadyExistError("Already exist a rental with id: " + clients.getClient_id());
        }
        clientsRepository.addClient(clients);
    }
    public void update(int id, Clients clients) {
        clientsRepository.update(id, clients);
    }

    public void delete(int id) {
        clientsRepository.delete(id);
    }
}
