package com.joaoguilherme.store.car.message;

import com.joaoguilherme.store.car.dto.CarPostDto;
import com.joaoguilherme.store.car.service.CarPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @Autowired
    private CarPostService carPostService;

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(CarPostDto carPostDto) {

        LOG.info("Received Car Post information: {}", carPostDto);
        carPostService.newPostDetails(carPostDto);
    }

}
