package com.wipro.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.springbootmvc.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/register")
    public String showForm(Model m) {
        return "userreg";
    }

    @PostMapping("/registersubmit")
    public String submitForm(@ModelAttribute("userdata") User user, Model m) {
        System.out.println("Form Submitted: " + user);
        m.addAttribute("user", user); // pass user to JSP
        return "usersuccess";
    }
}