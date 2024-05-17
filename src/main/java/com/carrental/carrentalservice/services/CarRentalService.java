package com.carrental.carrentalservice.services;

import com.carrental.carrentalservice.dtos.CarRentalRequestDto;
import com.carrental.carrentalservice.dtos.CarRentalResponseDto;
import com.carrental.carrentalservice.dtos.CarReturnRequestDto;
import com.carrental.carrentalservice.dtos.CarReturnResponseDto;
import com.carrental.carrentalservice.models.Car;
import com.carrental.carrentalservice.models.CarStatus;
import com.carrental.carrentalservice.models.Consumer;
import com.carrental.carrentalservice.models.ConsumerCarRental;
import com.carrental.carrentalservice.repositories.CarRepository;
import com.carrental.carrentalservice.repositories.ConsumerCarRentalRepository;
import com.carrental.carrentalservice.repositories.ConsumerRepository;
import com.carrental.carrentalservice.strategies.RentCalculationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CarRentalService {
    @Autowired
    CarRepository carRepository;

    @Autowired
    ConsumerCarRentalRepository consumerCarRentalRepository;

    @Autowired
    RentCalculationStrategy rentCalculationStrategy;

    @Autowired
    ConsumerRepository consumerRepository;
    public CarRentalResponseDto rentCar(CarRentalRequestDto carRentalRequestDto) {
        Car car = carRepository.findByRegistrationNumber(carRentalRequestDto.getRegistrationNumber());
        if(car.getCarStatus()== CarStatus.AVAILABLE){

            car.setCarStatus(CarStatus.RENTED);
            carRepository.save(car);

            Optional<Consumer> optionalConsumer = consumerRepository.findById(carRentalRequestDto.getUserId());
            if(optionalConsumer.isEmpty()){
                throw new RuntimeException("User unavailable");
            }

            Consumer consumer = optionalConsumer.get();

            ConsumerCarRental consumerCarRental = new ConsumerCarRental();
            consumerCarRental.setCar(car);
            consumerCarRental.setConsumer(consumer);
            consumerCarRental.setRentedOn(new Date());

            consumerCarRentalRepository.save(consumerCarRental);

            CarRentalResponseDto carRentalResponseDto = new CarRentalResponseDto();
            carRentalResponseDto.setRegistrationNumber(car.getRegistrationNumber());
            carRentalResponseDto.setCarType(car.getCarType());
            carRentalResponseDto.setConsumerName(consumer.getName());
            carRentalResponseDto.setConsumerContactNo(consumer.getContactNo());
            carRentalResponseDto.setRentedOn(consumerCarRental.getRentedOn());

            return carRentalResponseDto;
        }else {
            throw new RuntimeException("Car is " + car.getCarStatus());
        }
    }

    public CarReturnResponseDto returnCar(CarReturnRequestDto carReturnRequestDto){
        CarReturnResponseDto carReturnResponseDto = new CarReturnResponseDto();

        Car car = carRepository.findByRegistrationNumber(carReturnRequestDto.getRegistrationNumber());
        if(car.getCarStatus()== CarStatus.RENTED){

            car.setCarStatus(CarStatus.AVAILABLE);
            carRepository.save(car);

            ConsumerCarRental consumerCarRental = consumerCarRentalRepository.findByCar_IdAndReturnedOnNull(car.getId());
            consumerCarRental.setReturnedOn(new Date());
            consumerCarRental.setTotalRent(rentCalculationStrategy.rentCalculator(consumerCarRental));
            consumerCarRentalRepository.save(consumerCarRental);

            Consumer consumer = consumerCarRental.getConsumer();

            carReturnResponseDto.setCarRegistrationNumber(car.getRegistrationNumber());
            carReturnResponseDto.setConsumerName(consumer.getName());
            carReturnResponseDto.setConsumerContactNo(consumer.getContactNo());
            carReturnResponseDto.setConsumerPersonalIdNo(consumer.getPersonalIdNo());
            carReturnResponseDto.setReturnedOn(consumerCarRental.getReturnedOn());
            carReturnResponseDto.setRentedOn(consumerCarRental.getRentedOn());
            carReturnResponseDto.setTotalRent(consumerCarRental.getTotalRent());

        }else {
            throw new RuntimeException("Car is " + car.getCarStatus());
        }

        return carReturnResponseDto;
    }
}
