package com.example.laborator5.controller;

import com.example.laborator5.entity.Clients;
import com.example.laborator5.entity.Rentals;
import com.example.laborator5.service.ClientsService;
import com.example.laborator5.service.RentalsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("clients")
public class ClientsController {
    @Autowired
    private ClientsService clientsService;

    @GetMapping("/all")
    public List<Clients> findAll() {
        return clientsService.findAll();
    }

    @PostMapping("/id")
    public void addClient(@RequestBody Clients clients) {
        clientsService.addClient(clients);
    }

    @GetMapping("{id}")
    public Clients findByIdPath(@PathVariable int id) {
        return clientsService.findByIdPath(id);
    }

    @GetMapping("id")
    public Clients findByIdParam(@RequestParam int id) {
        return clientsService.findByIdParam(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Clients clients) {
        clientsService.update(id, clients);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        clientsService.delete(id);
    }
}
