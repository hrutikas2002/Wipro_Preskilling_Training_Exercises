package com.wipro.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @GetMapping("/weather")
    public String getWeather(
            @RequestParam String city,
            @RequestParam String day) {

        return "Weather in " + city + " for " + day + " is cloudy.";
    }
    
    @GetMapping("/tocentigrade/{fahrenheit}")
    public String convertToCentigrade(@PathVariable double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        return fahrenheit + " Fahrenheit = " + String.format("%.2f", celsius) + "Celcius";
    }
}