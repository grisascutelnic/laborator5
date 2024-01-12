package com.example.laborator5.repository;

import com.example.laborator5.entity.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehiclesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Vehicles> findAll() {
        return jdbcTemplate.query("select * from Vehicles", (rs, rowNum) -> {
            Vehicles vehicles = new Vehicles();
            vehicles.setVehicle_id(rs.getInt("vehicle_id"));
            vehicles.setBrand(rs.getString("brand"));
            vehicles.setModel(rs.getString("model"));
            vehicles.setYear(rs.getInt("year"));
            vehicles.setNumber(rs.getString("number"));
            vehicles.setStatus(rs.getString("status"));
            vehicles.setCost(rs.getDouble("cost"));
            return vehicles;
        });
    }

    public Vehicles findByIdPath(int id) {
        return jdbcTemplate.queryForObject("select * from Vehicles where vehicle_id = ?",
                (vehicles, rowNum) ->
                        new Vehicles(
                                vehicles.getInt("vehicle_id"),
                                vehicles.getString("brand"),
                                vehicles.getString("model"),
                                vehicles.getInt("year"),
                                vehicles.getString("number"),
                                vehicles.getString("status"),
                                vehicles.getDouble("cost")
                        ), id);
    }

    public Vehicles findByIdParam(int id) {
        return jdbcTemplate.queryForObject("select * from Vehicles where vehicle_id = ?",
                (vehicles, rowNum) ->
                        new Vehicles(
                                vehicles.getInt("vehicle_id"),
                                vehicles.getString("brand"),
                                vehicles.getString("model"),
                                vehicles.getInt("year"),
                                vehicles.getString("number"),
                                vehicles.getString("status"),
                                vehicles.getDouble("cost")
                        ), id);
    }

    public void addVehicle(Vehicles vehicles) {
        String sql = "insert into Vehicles (brand, model, year, number, status, cost) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, vehicles.getBrand(), vehicles.getModel(), vehicles.getYear(), vehicles.getNumber(), vehicles.getStatus(), vehicles.getCost());
    }

    public void addVehicleId(Vehicles vehicles) {
        String sql = "insert into Vehicles (vehicle_id, brand, model, year, number, status, cost) values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, vehicles.getVehicle_id(), vehicles.getBrand(), vehicles.getModel(), vehicles.getYear(), vehicles.getNumber(), vehicles.getStatus(), vehicles.getCost());
    }

    public void update(int id, Vehicles vehicles) {
        String sql = "update Vehicles set brand = ?, model = ?, year = ?, number = ?, status = ?, cost = ? where vehicle_id = ?";

        jdbcTemplate.update(sql, vehicles.getBrand(), vehicles.getModel(), vehicles.getYear(), vehicles.getNumber(), vehicles.getStatus(), vehicles.getCost(), id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM vehicles where vehicle_id = ?";

        jdbcTemplate.update(sql, id);
    }

    public boolean existById(int id) {
        String sql = "SELECT count(*) FROM Vehicles where vehicle_id = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);

        return count > 0;
    }

    public boolean alreadyExistId(int id) {
        String sql = "SELECT count(*) FROM Vehicles where vehicle_id = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count > 0;
    }
}
