package com.joaoguilherme.api.service;

import com.joaoguilherme.api.client.CarPostStoreClient;
import com.joaoguilherme.api.dto.OwnerPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    public void createOwnerCar(OwnerPostDto ownerPostDto) {
        carPostStoreClient.ownerPostsClient(ownerPostDto);
    }

}
