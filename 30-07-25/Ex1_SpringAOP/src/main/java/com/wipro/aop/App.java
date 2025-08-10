package com.wipro.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.wipro.aop.service.AirTravelProcess;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan("com.wipro.aop") 
@EnableAspectJAutoProxy
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        AirTravelProcess process = context.getBean(AirTravelProcess.class);

        try {
            process.checkIn(true);
            process.collectBoardingPass();
            process.doSecurityCheck();
            process.doBoarding();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        context.close();
    }
}
