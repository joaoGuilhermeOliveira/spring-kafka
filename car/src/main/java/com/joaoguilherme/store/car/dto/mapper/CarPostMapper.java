package com.joaoguilherme.store.car.mapper;

import com.joaoguilherme.store.car.dto.CarPostDto;
import com.joaoguilherme.store.car.entity.CarPostEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.internal.bytebuddy.matcher.StringMatcher;
import org.springframework.stereotype.Component;

@Component
public class CarPostMapper {


    public CarPostDto toDto(CarPostEntity carPostEntity) {
        return new ModelMapper().map(carPostEntity, CarPostDto.class);
    }

    public CarPostEntity toEntity(CarPostDto carPostDto) {
        return new ModelMapper().map(carPostDto, CarPostEntity.class);
    }
}
