package com.loharaniket.linkforge_springboot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.loharaniket.linkforge_springboot.dto.UrlRequestDto;
import com.loharaniket.linkforge_springboot.dto.UrlResponceDto;
import com.loharaniket.linkforge_springboot.model.Url;
import com.loharaniket.linkforge_springboot.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
public class UrlShortController {

    @Autowired
    private final UrlService service;

    @PostMapping
    public ResponseEntity<UrlResponceDto> urlRequest(@RequestBody UrlRequestDto request) {
        Url urlRequest = service.insertUrlDB(request.getUrl());
        var url = UrlResponceDto.builder()
                .shortUrl("http://localhost:8080/" + urlRequest.getShortUrl())
                .dateTime(urlRequest.getCreatedDateTime())
                .build();
        return ResponseEntity.ok(url);
    }

    @GetMapping("/{url}")
    public void acessUrl(@PathVariable String url, HttpServletResponse res)
            throws IOException {
        res.sendRedirect(service.acessLongUrl(url).getUrl());
    }

}
