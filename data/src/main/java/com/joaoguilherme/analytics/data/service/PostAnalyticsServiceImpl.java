package com.joaoguilherme.analytics.data.service;

import com.joaoguilherme.analytics.data.dto.CarPostDto;
import com.joaoguilherme.analytics.data.entity.BrandAnalyticEntity;
import com.joaoguilherme.analytics.data.entity.CarModelAnalyticsEntity;
import com.joaoguilherme.analytics.data.entity.CarModelPriceEntity;
import com.joaoguilherme.analytics.data.repository.BrandAnalyticsRepository;
import com.joaoguilherme.analytics.data.repository.CarModelAnalyticsRepository;
import com.joaoguilherme.analytics.data.repository.CarPriceAnalyticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostAnalyticsServiceImpl implements PostAnalyticsService{

    private final BrandAnalyticsRepository brandAnalyticsRepository;

    private final CarModelAnalyticsRepository carModelAnalyticsRepository;

    private final CarPriceAnalyticsRepository carPriceAnalyticsRepository;

    @Override
    public void saveDataAnalytics(CarPostDto carPostDto) {
        saveBrandAnalytics(carPostDto.getBrand());
        saveCarModelAnalytics(carPostDto.getModel());
        saveCarModelPriceAnalytics(carPostDto.getModel(), carPostDto.getPrice());
    }

    private void saveBrandAnalytics(String brand) {
        BrandAnalyticEntity brandAnalyticEntity = new BrandAnalyticEntity();

        brandAnalyticsRepository.findByBrand(brand).ifPresentOrElse(item ->{
            item.setPosts(item.getPosts()+1);
            brandAnalyticsRepository.save(item);
        }, () -> {
            brandAnalyticEntity.setBrand(brand);
            brandAnalyticEntity.setPosts(1L);
            brandAnalyticsRepository.save(brandAnalyticEntity);
        });

    }

    private void saveCarModelAnalytics(String carModel) {

        CarModelAnalyticsEntity carModelAnalyticsEntity = new CarModelAnalyticsEntity();

        carModelAnalyticsRepository.findByModel(carModel).ifPresentOrElse(item ->{
            item.setPosts(item.getPosts()+1);
            carModelAnalyticsRepository.save(item);
        }, () -> {
            carModelAnalyticsEntity.setModel(carModel);;
            carModelAnalyticsEntity.setPosts(1L);
            carModelAnalyticsRepository.save(carModelAnalyticsEntity);
        });

    }

    private void saveCarModelPriceAnalytics(String carModel, Double price) {

        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();

        carModelPriceEntity.setModel(carModel);
        carModelPriceEntity.setPrice(price);
        carPriceAnalyticsRepository.save(carModelPriceEntity);
    }

}
