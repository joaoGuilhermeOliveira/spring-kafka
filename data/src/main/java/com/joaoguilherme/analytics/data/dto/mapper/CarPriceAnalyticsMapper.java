package com.joaoguilherme.analytics.data.dto.mapper;

import com.joaoguilherme.analytics.data.dto.CarModelAnalyticDto;
import com.joaoguilherme.analytics.data.dto.CarPriceAnalyticsDto;
import com.joaoguilherme.analytics.data.entity.CarModelAnalyticsEntity;
import com.joaoguilherme.analytics.data.entity.CarModelPriceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarPriceAnalyticsMapper {

    public CarPriceAnalyticsDto toDto (CarModelPriceEntity carModelPriceEntity) {
        return new ModelMapper().map(carModelPriceEntity, CarPriceAnalyticsDto.class);
    }

    public CarModelPriceEntity toEntity (CarPriceAnalyticsDto carPriceAnalyticsDto) {
        return new ModelMapper().map(carPriceAnalyticsDto, CarModelPriceEntity.class);
    }

}
