package com.loharaniket.linkforge_springboot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.loharaniket.linkforge_springboot.dto.UrlRequestDto;
import com.loharaniket.linkforge_springboot.dto.UrlResponceDto;
import com.loharaniket.linkforge_springboot.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<UrlResponceDto> urlRequest(@RequestBody UrlRequestDto request) {
        var url = UrlResponceDto.builder()
                .shortUrl(request.getUrl())
                .dateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(url);
    }

    @GetMapping("/{url}")
    public void acessUrl(@PathVariable String url, HttpServletResponse res) throws IOException {
        res.sendRedirect(service.findorgUrl(url));
    }

}
