package com.carrental.carrentalservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Car extends BaseModel{
    private String name;

    private String registrationNumber;

    @Enumerated(value = EnumType.STRING)
    private CarStatus carStatus;

    @Enumerated(value = EnumType.STRING)
    private CarType carType;
}
