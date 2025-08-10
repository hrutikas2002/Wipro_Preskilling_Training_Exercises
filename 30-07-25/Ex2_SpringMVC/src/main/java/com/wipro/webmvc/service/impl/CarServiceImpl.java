package com.wipro.webmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.webmvc.service.repo.CarRepo;

@Service
public class CarServiceImpl implements CarService
{
	@Autowired
	private CarRepo carRepo;

	@Override
	public List<String> getCarList() {
		return carRepo.getCars();
	}
}


