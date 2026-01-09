package com.loharaniket.linkforge_springboot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeController {

    @GetMapping("/")
    public String getMethodName() {
        return "<h1>Welcome to LinkForge</h1>";
    }
    

}
