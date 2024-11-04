package com.joaoguilherme.api.controller;


import com.joaoguilherme.api.dto.OwnerPostDto;
import com.joaoguilherme.api.service.OwnerPostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerPostController {

    private final Logger LOG = LoggerFactory.getLogger(OwnerPostController.class);

    private final OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity createOwnerCar (@RequestBody OwnerPostDto ownerPostDto) {

        LOG.info("USING REST API - Creating new user: {}", ownerPostDto);

        ownerPostService.createOwnerCar(ownerPostDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
