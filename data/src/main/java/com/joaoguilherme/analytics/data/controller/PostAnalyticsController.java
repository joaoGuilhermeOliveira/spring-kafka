package com.joaoguilherme.analytics.data.controller;

import com.joaoguilherme.analytics.data.dto.BrandAnalyticsDto;
import com.joaoguilherme.analytics.data.dto.CarModelAnalyticDto;
import com.joaoguilherme.analytics.data.dto.CarPriceAnalyticsDto;
import com.joaoguilherme.analytics.data.service.PostAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class PostAnalyticsController {

    private final PostAnalyticsService postAnalyticsService;

    @GetMapping("/brands")
    public ResponseEntity<List<BrandAnalyticsDto>> getBrandAnalytic() {
        return ResponseEntity.status(HttpStatus.FOUND).body(postAnalyticsService.getBrandAnalytic());
    }

    @GetMapping("/models")
    public ResponseEntity<List<CarModelAnalyticDto>> getCarModelAnalytic() {
        return ResponseEntity.status(HttpStatus.FOUND).body(postAnalyticsService.getCarModelAnalytic());
    }

    @GetMapping("/prices")
    public ResponseEntity<List<CarPriceAnalyticsDto>> getCarPriceAnalytic() {
        return ResponseEntity.status(HttpStatus.FOUND).body(postAnalyticsService.getCarPriceAnalytic());
    }
}
