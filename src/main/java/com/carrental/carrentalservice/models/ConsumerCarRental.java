package com.carrental.carrentalservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class ConsumerCarRental extends BaseModel{
    @ManyToOne
    private Car car;

    @ManyToOne
    private Consumer consumer;

    private Date rentedOn;

    private Date returnedOn;

    private long totalRent;
}
