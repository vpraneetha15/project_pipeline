package com.example.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public class ProductRepository {

    private JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Product product) {

        String sql =
                "insert into product(name,price,quantity) values(?,?,?)";

        return jdbcTemplate.update(sql,
                product.getName(),
                product.getPrice(),
                product.getQuantity());
    }

    public List<Product> findAll() {

        String sql="select * from product";

        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Product.class));
    }

    public Product findById(int id){

        String sql="select * from product where id=?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Product.class),
                id);
    }

    public int update(Product product){

        String sql=
                "update product set name=?,price=?,quantity=? where id=?";

        return jdbcTemplate.update(sql,
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getId());
    }

    public int delete(int id){

        String sql="delete from product where id=?";

        return jdbcTemplate.update(sql,id);
    }

}