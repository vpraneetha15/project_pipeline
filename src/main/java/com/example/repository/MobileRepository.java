package com.example.repository;

import com.example.model.Mobile;
import com.example.model.Product;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MobileRepository {
    private JdbcTemplate jdbcTemplate;

    public MobileRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Mobile> findAll() {

        String sql="select * from mobile";

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Mobile.class));
    }
    public Mobile findById(Long id) {
        String sql = "SELECT * FROM mobile WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Mobile.class), id);
    }
    public int addMobile(Mobile mobile) {
        String sql = "INSERT INTO mobile (name, brand, price) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, mobile.getName(), mobile.getBrand(), mobile.getPrice());
    }
    public int updateMobile(Mobile mobile) {
        String sql = "UPDATE mobile SET name = ?, brand = ?, price = ? WHERE id = ?";
        return jdbcTemplate.update(sql, mobile.getName(), mobile.getBrand(), mobile.getPrice(), mobile.getId());
    }
    public int deleteMobile(Long id) {
        String sql = "DELETE FROM mobile WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    
}
}
