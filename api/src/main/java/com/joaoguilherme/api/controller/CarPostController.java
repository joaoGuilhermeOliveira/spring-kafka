package com.joaoguilherme.api.controller;

import com.joaoguilherme.api.dto.CarPostDto;
import com.joaoguilherme.api.message.KafkaProducerMessage;
import com.joaoguilherme.api.service.CarPostStoreService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarPostController {

    private final Logger LOG = LoggerFactory.getLogger(CarPostController.class);

    private final CarPostStoreService carPostStoreService;

    private final KafkaProducerMessage kafkaProducerMessage;

    @PostMapping("/post")
    public ResponseEntity postCarForSale(@RequestBody CarPostDto carPostDto) {

        LOG.info("USING KAFKA EVENTS/MESSAGES - Producer Car Post information: {}", carPostDto);

        kafkaProducerMessage.sendMessage(carPostDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDto>> getCarSales() {
        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales());
    }

    @PutMapping("/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostDto carPostDto, @PathVariable("id") String id) {
        carPostStoreService.changeCarForSale(carPostDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarForSale(@PathVariable("id") String id) {
        carPostStoreService.removeCarForSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
