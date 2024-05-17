package com.carrental.carrentalservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRentalRequestDto {
    private String registrationNumber;
    private long userId;
}
