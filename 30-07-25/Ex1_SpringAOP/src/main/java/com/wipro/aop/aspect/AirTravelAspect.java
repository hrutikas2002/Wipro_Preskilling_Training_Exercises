package com.wipro.aop.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.wipro.aop.exception.NoSeatAvailableException;

@Aspect
@Component
public class AirTravelAspect {
	// Before advice for showPhotoId before checkIn
    @Before("execution(* com.wipro.aop.service.AirTravelProcess.checkIn(..))")
    public void showPhotoId() {
        System.out.println("Please show Photo ID before check-in.");
    }

    // Before advice for showBoardingPass before security check and boarding
    @Before("execution(* com.wipro.aop.service.AirTravelProcess.do*(..)) || execution(* com.airtravel.AirTravelProcess.doBoarding(..))")
    public void showBoardingPass() {
        System.out.println("Please show your Boarding Pass.");
    }

    // After throwing advice for NoSeatAvailableException
    @AfterThrowing(
        pointcut = "execution(* com.wipro.aop.service.AirTravelProcess.checkIn(..))",
        throwing = "ex")
    public void handleNoSeatAvailableException(NoSeatAvailableException ex) {
        System.out.println("Contact to Ailine Manager!!");
    }
}
