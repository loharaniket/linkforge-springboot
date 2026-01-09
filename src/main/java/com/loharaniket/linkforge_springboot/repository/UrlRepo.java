package com.loharaniket.linkforge_springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loharaniket.linkforge_springboot.model.Url;


@Repository
public interface UrlRepo extends JpaRepository<Url, Long> {
    Optional<Url> findByShortUrl(String shortUrl);
    Optional<Url> findByOrgUrl(String orgUrl);
}
