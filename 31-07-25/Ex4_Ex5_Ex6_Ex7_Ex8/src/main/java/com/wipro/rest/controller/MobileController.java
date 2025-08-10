package com.wipro.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.rest.dto.Mobile;
import com.wipro.rest.service.MobileService;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    private MobileService service;

    @PostMapping
    public String addMobile(@RequestBody Mobile mobile) {
        service.addMobile(mobile);
        return "Mobile added.";
    }

    @GetMapping
    public List<Mobile> getMobiles() {
        return service.getAllMobiles();
    }

    @PutMapping
    public String updateMobile(@RequestBody Mobile mobile) {
        service.updateMobile(mobile);
        return "Mobile updated.";
    }

    @DeleteMapping
    public String deleteMobile(@RequestParam int id) {
        service.deleteMobile(id);
        return "Mobile deleted.";
    }
}