package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.ProductDTO;
import com.example.model.Mobile;
import com.example.model.Product;
import com.example.repository.MobileRepository;
import com.example.repository.ProductRepository;

@Service
public class MobileService {

    private MobileRepository repository;

    public MobileService(MobileRepository repository) {
        this.repository = repository;
    }

    public int addMobile(ProductDTO dto) {

        Mobile mobile = new Mobile();

        mobile.setName(dto.getName());
        mobile.setPrice(dto.getPrice());

        return repository.addMobile(mobile);
    }

    public int addMobile(Mobile m){
        return repository.addMobile(m);
    }

    public List<Mobile> findAll(){
        return repository.findAll();
    }

    public Mobile findById(Long id){
        return repository.findById(id);
    }

    public int update(Mobile p){
        return repository.updateMobile(p);
    }

    public int delete(Long id){
        return repository.deleteMobile(id);
    }

}