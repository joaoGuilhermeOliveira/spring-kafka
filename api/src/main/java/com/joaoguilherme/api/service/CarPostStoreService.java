package com.joaoguilherme.api.service;

import com.joaoguilherme.api.client.CarPostStoreClient;
import com.joaoguilherme.api.dto.CarPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    public List<CarPostDto> getCarForSales() {
        return carPostStoreClient.carForSaleClient();
    }

    public void changeCarForSale(CarPostDto carPost, String id) {
        carPostStoreClient.changeCarForSaleClient(carPost, id);
    }

    public void removeCarForSale(String id) {
        carPostStoreClient.deleteCarForSaleClient(id);
    }
}
