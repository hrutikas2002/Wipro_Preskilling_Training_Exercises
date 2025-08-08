package com.wipro.letsgo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.letsgo.entity.VehicleMovement;
import com.wipro.letsgo.service.VehicleMovementService;

@RestController

public class VehicleMovementController {
	@Autowired
	private VehicleMovementService service;
	
	// POST /move
    @PostMapping("/move")
    public ResponseEntity<VehicleMovement> moveVehicle(@RequestBody VehicleMovement movement) {
        VehicleMovement saved = service.saveMovement(movement);
        return ResponseEntity.ok(saved);
    }

    // GET /vehicles
    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleMovement>> getAllMovements() {
        return ResponseEntity.ok(service.getAllMovements());
    }
}
