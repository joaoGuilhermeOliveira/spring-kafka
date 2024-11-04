package com.joaoguilherme.analytics.data.service;

import com.joaoguilherme.analytics.data.dto.CarPostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostAnalyticsService {

    void saveDataAnalytics(CarPostDto carPostDto);

}
