package com.wipro.rest.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wipro.rest.dto.Mobile;

@Repository
public class MobileRepo {
	private final List<Mobile> mobileList = new ArrayList<>();

    public void save(Mobile mobile) {
        mobileList.add(mobile);
        System.out.println("Mobile Added " + mobile);
    }

    public List<Mobile> findAll() {
        return mobileList;
    }

    public void update(Mobile updatedMobile) {
        for (Mobile mobile : mobileList) {
            if (mobile.getId() == updatedMobile.getId()) {
                mobile.setMake(updatedMobile.getMake());
                mobile.setModelNumber(updatedMobile.getModelNumber());
                mobile.setPrice(updatedMobile.getPrice());
                System.out.println("Mobile record updated! " + mobile);
                return;
            }
        }
    }

    public void deleteById(int id) {
        mobileList.removeIf(m -> m.getId() == id);
        System.out.println("Mobile Record deleted with id " + id);
    }
}
