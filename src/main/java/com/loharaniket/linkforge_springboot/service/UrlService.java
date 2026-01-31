package com.loharaniket.linkforge_springboot.service;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.loharaniket.linkforge_springboot.model.Url;
import com.loharaniket.linkforge_springboot.repository.UrlRepo;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UrlService {

    @Autowired
    private final UrlRepo repository;

    private static String createUrlShort(long id) {
        String encode = Base64.getUrlEncoder().encodeToString(String.valueOf(id).getBytes());
        return encode;
    }

    private static long decodeId(String url) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(url);
        String decodeValue = new String(bytes);
        return Long.parseLong(decodeValue);
    }

    @Transactional
    public Url insertUrlDB(String request) {
        var setUrl = Url.builder()
                .url(request)
                .shortUrl(request)
                .createdDateTime(LocalDateTime.now())
                .build();

        var url = repository.save(setUrl);
        url.setShortUrl(createUrlShort(url.getId()));
        return url;
    }

    public Url acessLongUrl(String request) {
        var url = repository.findById(decodeId(request))
                .orElseThrow(() -> new ResourceAccessException("not found url"));
        return url;
    }
}
