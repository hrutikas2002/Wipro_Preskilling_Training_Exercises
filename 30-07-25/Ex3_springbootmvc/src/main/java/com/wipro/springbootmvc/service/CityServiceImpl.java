package com.wipro.springbootmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springbootmvc.repo.CityRepo;

@Service
public class CityServiceImpl implements CityService
{
	 @Autowired
	    private CityRepo cityRepo;

	    @Override
	    public List<String> getCityList() {
	        return cityRepo.getCities();
	    }
}
