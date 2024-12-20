package com.joaoguilherme.store.car.service;

import com.joaoguilherme.store.car.dto.CarPostDto;
import com.joaoguilherme.store.car.entity.CarPostEntity;
import com.joaoguilherme.store.car.repository.CarPostRepository;
import com.joaoguilherme.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CarPostServiceImpl implements CarPostService{

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Autowired
    private com.joaoguilherme.store.car.mapper.CarPostMapper carPostMapper;

    @Override
    public void newPostDetails(CarPostDto carPostDto) {
        ownerPostRepository.findById(carPostDto.getOwnerId()).ifPresentOrElse(owner -> {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            CarPostEntity carPostEntity = carPostMapper.toEntity(carPostDto);
            carPostEntity.setId(null);
            carPostEntity.setCreatedDate(LocalDateTime.now().format(formatter));
            carPostEntity.setOwnerPost(owner);
            carPostRepository.save(carPostEntity);
        }, () -> {
            throw new NoSuchElementException("Owner not found for ID: " + carPostDto.getOwnerId());
        });
    }

    @Override
    public List<CarPostDto> getCarSales() {
        return carPostRepository.findAll().stream().map(carPostMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void changeCarSale(CarPostDto carPostDto, Long postId) {

        carPostRepository.findById(postId).ifPresentOrElse(item -> {
            item.setModel(carPostDto.getModel());
            item.setBrand(carPostDto.getBrand());
            item.setPrice(carPostDto.getPrice());
            item.setDescription(carPostDto.getDescription());
            item.setEngineVersion(carPostDto.getEngineVersion());
            item.setCity(carPostDto.getCity());
            item.setCreatedDate(carPostDto.getCreatedDate());
            item.setContact(carPostDto.getContact());

            carPostRepository.save(item);
        }, () -> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }


}
