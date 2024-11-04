package com.joaoguilherme.analytics.data.service;

import com.joaoguilherme.analytics.data.dto.BrandAnalyticsDto;
import com.joaoguilherme.analytics.data.dto.CarModelAnalyticDto;
import com.joaoguilherme.analytics.data.dto.CarPostDto;
import com.joaoguilherme.analytics.data.dto.CarPriceAnalyticsDto;
import com.joaoguilherme.analytics.data.entity.CarModelPriceEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostAnalyticsService {

    void saveDataAnalytics(CarPostDto carPostDto);


    List<BrandAnalyticsDto> getBrandAnalytic();

    List<CarModelAnalyticDto> getCarModelAnalytic();

    List<CarPriceAnalyticsDto> getCarPriceAnalytic();
}
