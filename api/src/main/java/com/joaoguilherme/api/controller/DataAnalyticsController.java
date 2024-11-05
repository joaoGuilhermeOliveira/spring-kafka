package com.joaoguilherme.api.controller;

import com.joaoguilherme.api.dto.BrandAnalyticsDto;
import com.joaoguilherme.api.dto.CarModelAnalyticDto;
import com.joaoguilherme.api.dto.CarPriceAnalyticsDto;
import com.joaoguilherme.api.service.CarPostStoreService;
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
public class DataAnalyticsController {

    private final CarPostStoreService carPostStoreService;

    @GetMapping("/brands")
    public ResponseEntity<List<BrandAnalyticsDto>> getBrandAnalytic() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getBrandAnalytic());
    }

    @GetMapping("/models")
    public ResponseEntity<List<CarModelAnalyticDto>> getCarModelAnalytic() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarModelAnalytic());
    }

    @GetMapping("/prices")
    public ResponseEntity<List<CarPriceAnalyticsDto>> getCarPriceAnalytic() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarPriceAnalytic());
    }

}
