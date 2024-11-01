package com.joaoguilherme.store.car.service;

import com.joaoguilherme.store.car.dto.CarPostDto;
import com.joaoguilherme.store.car.entity.CarPostEntity;
import com.joaoguilherme.store.car.repository.CarPostRepository;
import com.joaoguilherme.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
