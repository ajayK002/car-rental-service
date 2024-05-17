package com.carrental.carrentalservice.dtos;

import com.carrental.carrentalservice.models.CarType;
import com.carrental.carrentalservice.models.Consumer;
import com.carrental.carrentalservice.models.ConsumerCarRental;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CarReturnResponseDto {
    private String carRegistrationNumber;
    private String consumerName;
    private String consumerContactNo;
    private String consumerPersonalIdNo;
    private Date rentedOn;
    private Date returnedOn;
    private long totalRent;
}
