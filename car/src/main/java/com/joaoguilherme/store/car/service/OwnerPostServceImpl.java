package com.joaoguilherme.store.car.service;

import com.joaoguilherme.store.car.dto.OwnerPostDto;
import com.joaoguilherme.store.car.entity.OwnerPostEntity;
import com.joaoguilherme.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServceImpl implements OwnerPostService{

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    @Override
    public void createOwnerPost(OwnerPostDto ownerPostDto) {
        OwnerPostEntity ownerPost = new OwnerPostEntity();
        ownerPost.setName(ownerPostDto.getName());
        ownerPost.setType(ownerPostDto.getType());
        ownerPost.setContactNumber(ownerPostDto.getContactNumber());

        ownerPostRepository.save(ownerPost);
    }
}
