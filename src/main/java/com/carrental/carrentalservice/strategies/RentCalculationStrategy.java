package com.carrental.carrentalservice.strategies;

import com.carrental.carrentalservice.models.ConsumerCarRental;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RentCalculationStrategy {
    public long rentCalculator(ConsumerCarRental consumerCarRental){
        long diffInMillies = Math.abs(consumerCarRental.getReturnedOn().getTime() - consumerCarRental.getRentedOn().getTime());
        long days =  TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return ((days+1) * 2000);
    }
}
