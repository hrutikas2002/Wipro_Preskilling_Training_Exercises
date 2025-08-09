package com.wipro.uber.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Ride {
	private Long id;
	private String riderName;
	private String pickup;
	private String destination;
	private boolean status; 
	private LocalDate bookingDate;
}
