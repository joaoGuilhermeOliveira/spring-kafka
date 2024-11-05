package com.joaoguilherme.api.client;

import com.joaoguilherme.api.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClient {

    private final String USER_STORE_SERVICE_URI = "http://localhost:8081/user";
    private final String POST_STORE_SERVICE_URI = "http://localhost:8081/sales";

    private final String DATA_ANALYTICS_SERVICE_URI = "http://localhost:8082/data";

    @Autowired
    RestTemplate restTemplate;

    public List<CarPostDto> carForSaleClient() {
        ResponseEntity<CarPostDto[]> responseEntity = restTemplate.getForEntity(POST_STORE_SERVICE_URI+"/cars", CarPostDto[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void ownerPostsClient(OwnerPostDto newUser) {
        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDto.class);
    }

    public void changeCarForSaleClient(CarPostDto carPostDto, String id) {
        restTemplate.put(POST_STORE_SERVICE_URI+"/car/"+id,carPostDto,CarPostDto.class);
    }

    public void deleteCarForSaleClient(String id) {
        restTemplate.delete(POST_STORE_SERVICE_URI+"/car/"+id);
    }

    public List<BrandAnalyticsDto> getBrandAnalytic() {
        ResponseEntity<BrandAnalyticsDto[]> responseEntity = restTemplate.getForEntity(DATA_ANALYTICS_SERVICE_URI+"/brands", BrandAnalyticsDto[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public List<CarModelAnalyticDto> getCarModelAnalytic() {
        ResponseEntity<CarModelAnalyticDto[]> responseEntity = restTemplate.getForEntity(DATA_ANALYTICS_SERVICE_URI+"/models", CarModelAnalyticDto[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public List<CarPriceAnalyticsDto> getCarPriceAnalytic() {
        ResponseEntity<CarPriceAnalyticsDto[]> responseEntity = restTemplate.getForEntity(DATA_ANALYTICS_SERVICE_URI+"/prices", CarPriceAnalyticsDto[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

}
