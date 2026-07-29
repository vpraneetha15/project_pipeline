package com.example.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.service.MobileService;
import com.example.model.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/Mobile")
public class MobileController {

    @Autowired
    private    MobileService mobileService;
    public MobileController(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    @PostMapping
    public String addMobile(@RequestBody Mobile mobile) {
        mobileService.addMobile(mobile);
        return "Mobile added successfully";
    }
    @GetMapping
    public List<Mobile> getAllMobiles() {
        return mobileService.findAll();
    }

    @GetMapping("/{id}")
    public Mobile getMobileById(@PathVariable Long id) {
        return mobileService.findById(id);
    }

    @PutMapping
    public String updateMobile(@RequestBody Mobile mobile) {
        mobileService.update(mobile);
        return "Mobile updated successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteMobile(@PathVariable Long id) {
        mobileService.delete(id);
        return "Mobile deleted successfully";
    }

}