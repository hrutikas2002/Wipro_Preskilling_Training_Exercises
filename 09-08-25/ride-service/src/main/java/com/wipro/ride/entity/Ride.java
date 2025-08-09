package com.wipro.ride.entity;

import java.time.LocalDate;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="ride_details")
public class Ride {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name="rider_name")
    private String riderName;
	@Column(name="pickup")
    private String pickup;
	@Column(name="destination")
    private String destination;
	@Column(name="status")
    private boolean status; 
	@Column(name="booking_date")
	private LocalDate bookingDate;
}
