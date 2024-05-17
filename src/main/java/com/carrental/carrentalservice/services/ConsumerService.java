package com.carrental.carrentalservice.services;

import com.carrental.carrentalservice.dtos.ConsumerRequestDto;
import com.carrental.carrentalservice.dtos.ConsumerResponseDto;
import com.carrental.carrentalservice.models.Consumer;
import com.carrental.carrentalservice.repositories.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;
    public Consumer registerUser(ConsumerRequestDto consumerRequestDto) {
        Optional<Consumer> optionalConsumer= consumerRepository.findByPersonalIdNo(consumerRequestDto.getPersonalIdNo());
        Consumer consumer = new Consumer();
        if (optionalConsumer.isEmpty()){
            Consumer newConsumer = new Consumer();
            newConsumer.setName(consumerRequestDto.getName());
            newConsumer.setContactNo(consumerRequestDto.getContactNo());
            newConsumer.setPersonalIdNo(consumerRequestDto.getPersonalIdNo());
            newConsumer.setCreatedDate(new Date());
            newConsumer.setLastModifiedDate(new Date());

            consumer = consumerRepository.save(newConsumer);
        }else {
            consumer = optionalConsumer.get();
        }
        return consumer;
    }
}
