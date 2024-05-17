package com.carrental.carrentalservice.controllers;

import com.carrental.carrentalservice.dtos.ConsumerRequestDto;
import com.carrental.carrentalservice.dtos.ConsumerResponseDto;
import com.carrental.carrentalservice.models.Consumer;
import com.carrental.carrentalservice.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    ConsumerService consumerService;

    @PostMapping("/consumer")
    public ConsumerResponseDto registerUser(@RequestBody ConsumerRequestDto consumerRequestDto){
        Consumer consumer = consumerService.registerUser(consumerRequestDto);
        ConsumerResponseDto consumerResponseDto = new ConsumerResponseDto();
        consumerResponseDto.setId(consumer.getId());
        consumerResponseDto.setName(consumer.getName());
        consumerResponseDto.setContactNo(consumer.getContactNo());
        consumerResponseDto.setPersonalIdNo(consumer.getPersonalIdNo());

        return consumerResponseDto;
    }
}
