package com.wipro.letsgo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.letsgo.entity.VehicleMovement;
import com.wipro.letsgo.repository.VehicleMovementRepository;

@Service
public class VehicleMovementServiceImpl implements VehicleMovementService{
	
	@Autowired
	private VehicleMovementRepository repository;

	@Override
	public VehicleMovement saveMovement(VehicleMovement movement) {
		return repository.save(movement);
	}

	@Override
	public List<VehicleMovement> getAllMovements() {
		return repository.findAll();      
	}

}
