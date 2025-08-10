package com.wipro.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.rest.dto.Mobile;
import com.wipro.rest.repository.MobileRepo;

@Service
public class MobileService {
	@Autowired
    private MobileRepo repository;

    public void addMobile(Mobile mobile) {
        System.out.println("Service: Adding mobile...");
        repository.save(mobile);
    }

    public List<Mobile> getAllMobiles() {
        System.out.println("Service: Getting all mobiles...");
        return repository.findAll();
    }

    public void updateMobile(Mobile mobile) {
        System.out.println("Service: Updating mobile...");
        repository.update(mobile);
    }

    public void deleteMobile(int id) {
        System.out.println("Service: Deleting mobile...");
        repository.deleteById(id);
    }
}
