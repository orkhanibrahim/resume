package com.orxanibrahim.resume_portal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "Hello buddy";
    }

    @GetMapping("/edit")
    public String edit(){
        return "edit page";
    }
}
