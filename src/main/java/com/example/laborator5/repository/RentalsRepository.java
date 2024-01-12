package com.example.laborator5.repository;

import com.example.laborator5.entity.Rentals;
import com.example.laborator5.entity.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Rentals> findAll() {
        String sql = "select * from Rentals";
        return  jdbcTemplate.query(sql, (rentals, rowNum) -> new Rentals(
                rentals.getInt("rental_id"),
                rentals.getInt("vehicle_id"),
                rentals.getInt("client_id"),
                rentals.getString("startdate"),
                rentals.getString("enddate"),
                rentals.getDouble("cost")
        ));
    }

    public Rentals findByIdPath(int id) {
        return jdbcTemplate.queryForObject("select * from Rentals where rental_id = ?",
                (rentals, rowNum) ->
                        new Rentals(
                                rentals.getInt("rental_id"),
                                rentals.getInt("vehicle_id"),
                                rentals.getInt("client_id"),
                                rentals.getString("startdate"),
                                rentals.getString("enddate"),
                                rentals.getDouble("cost")
                        ), id);
    }

    public Rentals findByIdParam(int id) {
        return jdbcTemplate.queryForObject("select * from Rentals where rental_id = ?",
                (rentals, rowNum) ->
                        new Rentals(
                                rentals.getInt("rental_id"),
                                rentals.getInt("vehicle_id"),
                                rentals.getInt("client_id"),
                                rentals.getString("startdate"),
                                rentals.getString("enddate"),
                                rentals.getDouble("cost")
                        ), id);
    }

    public void addRental(Rentals rentals) {
        String sql = "insert into Rentals (rental_id, vehicle_id, client_id, startdate, enddate, cost) values (?,?,?,?,?,?) ";
        jdbcTemplate.update(sql, rentals.getRental_id(), rentals.getVehicle_id(), rentals.getClient_id(), rentals.getStartdate(), rentals.getEnddate(), rentals.getCost());
    }

    public void update(int id, Rentals rentals) {
        String sql = "update rentals set rental_id = ?, vehicle_id = ?, client_id = ?, startdate = ?, enddate = ?, cost = ? where rental_id = ?";

        jdbcTemplate.update(sql, rentals.getRental_id(), rentals.getVehicle_id(), rentals.getClient_id(), rentals.getStartdate(), rentals.getEnddate(), rentals.getCost(), id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM Rentals where rental_id = ?";

        jdbcTemplate.update(sql, id);
    }

    public boolean existById(int id) {
        String sql = "SELECT count(*) FROM Rentals where rental_id = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);

        return count > 0;
    }
    public boolean alreadyExistId(int id) {
        String sql = "select count(*) from Rentals where rental_id = ?";
        Integer count =  jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count > 0;
    }
}
