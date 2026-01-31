package com.loharaniket.linkforge_springboot.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loharaniket.linkforge_springboot.model.Url;
import com.loharaniket.linkforge_springboot.repository.UrlRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UrlService {

    @Autowired
    private final UrlRepo repository;

    public Url generateUrl(String request) {
        var url = Url.builder()
        .url(request)
        .shortUrl(request)
        .createdDateTime(LocalDateTime.now())
                .build();
        repository.save(url);
        return url;
    }

    // public Url processUrl(Url url) throws RuntimeException {
    //     boolean isExist = repo.findByOrgUrl(url.getOrgUrl()).isPresent();
    //     if (!isExist) {
    //         String shortLink = UUID.randomUUID().toString();
    //         url.setShortUrl(shortLink.substring(0, 6));
    //         repo.save(url);
    //     } else {
    //         Url getExistUrl = repo.findByOrgUrl(url.getOrgUrl()).orElseThrow(() -> new RuntimeException());
    //         url.setShortUrl(getExistUrl.getShortUrl());
    //         url.setId(getExistUrl.getId());
    //     }
    //     return url;
    // }

    // public String findorgUrl(String shortUrl) {
    //     Url findUrl = repo.findByShortUrl(shortUrl).orElse(new Url());
    //     if (findUrl.getShortUrl() != null || findUrl.getOrgUrl() != null) {
    //         return findUrl.getOrgUrl();
    //     }
    //     return "http://localhost:8080/";
    // }
}
