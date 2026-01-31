package com.loharaniket.linkforge_springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loharaniket.linkforge_springboot.model.Url;


@Repository
public interface UrlRepo extends JpaRepository<Url, Long> {
    
}
