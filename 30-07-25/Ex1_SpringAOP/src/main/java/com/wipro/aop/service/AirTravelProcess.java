package com.wipro.aop.service;

import org.springframework.stereotype.Component;

import com.wipro.aop.exception.NoSeatAvailableException;

@Component
public class AirTravelProcess {
	 public void checkIn(Boolean flag) throws NoSeatAvailableException {
	        if (flag==true) {
	            System.out.println("Check-in successful.");
	        } else {
	            throw new NoSeatAvailableException("No seat available.");
	        }
	    }

	    public void collectBoardingPass() {
	        System.out.println("Boarding pass collected.");
	    }

	    public void doSecurityCheck() {
	        System.out.println("Security check done.");
	    }

	    public void doBoarding() {
	        System.out.println("Boarding completed.");
	    }
}
