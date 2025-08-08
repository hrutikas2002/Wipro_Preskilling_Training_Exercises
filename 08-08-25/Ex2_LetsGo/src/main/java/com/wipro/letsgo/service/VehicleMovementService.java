package com.wipro.letsgo.service;

import java.util.List;

import com.wipro.letsgo.entity.VehicleMovement;

public interface VehicleMovementService {
	public VehicleMovement saveMovement(VehicleMovement movement);
	public List<VehicleMovement> getAllMovements();
}
