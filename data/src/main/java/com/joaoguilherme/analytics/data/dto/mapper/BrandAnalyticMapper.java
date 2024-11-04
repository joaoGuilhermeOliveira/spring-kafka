package com.joaoguilherme.analytics.data.dto.mapper;

import com.joaoguilherme.analytics.data.dto.BrandAnalyticsDto;
import com.joaoguilherme.analytics.data.entity.BrandAnalyticEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BrandAnalyticMapper {

    public BrandAnalyticsDto toDto(BrandAnalyticEntity brandAnalyticEntity) {
        return new ModelMapper().map(brandAnalyticEntity, BrandAnalyticsDto.class);
    }

    public BrandAnalyticEntity toEntity(BrandAnalyticsDto brandAnalyticDto) {
        return new ModelMapper().map(brandAnalyticDto, BrandAnalyticEntity.class);
    }

}
