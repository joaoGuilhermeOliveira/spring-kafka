package com.joaoguilherme.store.car.service;

import com.joaoguilherme.store.car.dto.OwnerPostDto;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwnerPost(OwnerPostDto ownerPostDto);

}
