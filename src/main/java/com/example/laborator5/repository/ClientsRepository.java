package com.example.laborator5.repository;

import com.example.laborator5.entity.Clients;
import com.example.laborator5.entity.Rentals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ClientsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Clients> findAll() {
        String sql = "select * from Clients";
        return  jdbcTemplate.query(sql, (clients, rowNum) -> new Clients(
                clients.getInt("client_id"),
                clients.getString("firstname"),
                clients.getString("lastname"),
                clients.getString("dob"),
                clients.getString("address"),
                clients.getString("phone")
        ));
    }

    public Clients findByIdPath(int id) {
        return jdbcTemplate.queryForObject("select * from Clients where client_id = ?",
                (clients, rowNum) ->
                        new Clients(
                                clients.getInt("client_id"),
                                clients.getString("firstname"),
                                clients.getString("lastname"),
                                clients.getString("dob"),
                                clients.getString("address"),
                                clients.getString("phone")
                        ), id);
    }

    public Clients findByIdParam(int id) {
        return jdbcTemplate.queryForObject("select * from Clients where client_id = ?",
                (clients, rowNum) ->
                        new Clients(
                                clients.getInt("client_id"),
                                clients.getString("firstname"),
                                clients.getString("lastname"),
                                clients.getString("dob"),
                                clients.getString("address"),
                                clients.getString("phone")
                        ), id);
    }

    public void addClient(Clients clients) {
        String sql = "insert into Clients (client_id, firstname, lastname, dob, address, phone) values (?,?,?,?,?,?) ";
        jdbcTemplate.update(sql, clients.getClient_id(), clients.getFirstname(), clients.getLastname(), clients.getDob(), clients.getAddress(), clients.getPhone());
    }

    public void update(int id, Clients clients) {
        String sql = "update clients set client_id = ?, firstname = ?, lastname = ?, dob = ?, address = ?, phone = ? where client_id = ?";

        jdbcTemplate.update(sql, clients.getClient_id(), clients.getFirstname(), clients.getLastname(), clients.getDob(), clients.getAddress(), clients.getPhone(), id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM Clients where client_id = ?";

        jdbcTemplate.update(sql, id);
    }

    public boolean existById(int id) {
        String sql = "SELECT count(*) FROM Clients where client_id = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);

        return count > 0;
    }
    public boolean alreadyExistId(int id) {
        String sql = "select count(*) from Clients where client_id = ?";
        Integer count =  jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count > 0;
    }
}
