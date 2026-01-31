package com.loharaniket.linkforge_springboot.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UrlResponceDto {
    private String shortUrl;
    private LocalDateTime dateTime;
}
