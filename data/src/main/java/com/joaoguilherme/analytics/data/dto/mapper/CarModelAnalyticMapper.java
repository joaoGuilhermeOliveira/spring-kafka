package com.joaoguilherme.analytics.data.dto.mapper;

import com.joaoguilherme.analytics.data.dto.CarModelAnalyticDto;
import com.joaoguilherme.analytics.data.entity.CarModelAnalyticsEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarModelAnalyticMapper {

    public CarModelAnalyticDto toDto (CarModelAnalyticsEntity carModelAnalyticsEntity) {
        return new ModelMapper().map(carModelAnalyticsEntity, CarModelAnalyticDto.class);
    }

    public CarModelAnalyticsEntity toEntity (CarModelAnalyticDto carModelAnalyticDto) {
        return new ModelMapper().map(carModelAnalyticDto, CarModelAnalyticsEntity.class);
    }

}
