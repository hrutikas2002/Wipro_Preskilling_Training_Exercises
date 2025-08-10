package com.wipro.springbootmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wipro.springbootmvc.service.CityService;

@Controller
public class CityController {
	@Autowired
    private CityService cityService;

    @GetMapping("/city")
    public String showCities(Model model) {
        List<String> cities = cityService.getCityList();
        model.addAttribute("cities", cities);
        return "citylist"; 
    }
}
