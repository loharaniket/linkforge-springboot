package com.loharaniket.linkforge_springboot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.loharaniket.linkforge_springboot.model.Url;
import com.loharaniket.linkforge_springboot.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class HomeController {

    @Autowired
    private UrlService service;
    
    @GetMapping("/")
    public String home() {
        return "<h1>Welcome to LinkForge</h1>";
    }

    @PostMapping("/")
    public ResponseEntity<?> getUrl(@RequestBody Url url) {
        if (url.getOrgUrl().startsWith("http") || url.getOrgUrl().startsWith("https:")) {
            Url processUrlReturn = service.processUrl(url);
            processUrlReturn.setShortUrl("http://localhost:8080/" + processUrlReturn.getShortUrl());
            return new ResponseEntity<>(processUrlReturn, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Not valid link", HttpStatus.BAD_REQUEST);

    }
    
    @GetMapping("/{url}")
    public void acessUrl(@PathVariable String url, HttpServletResponse res) throws IOException {
        res.sendRedirect(service.findorgUrl(url));
    }

}
