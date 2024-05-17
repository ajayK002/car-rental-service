package com.carrental.carrentalservice.controllers;

import com.carrental.carrentalservice.dtos.CarRentalRequestDto;
import com.carrental.carrentalservice.dtos.CarRentalResponseDto;
import com.carrental.carrentalservice.dtos.CarReturnRequestDto;
import com.carrental.carrentalservice.dtos.CarReturnResponseDto;
import com.carrental.carrentalservice.services.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarRentalController {
    @Autowired
    CarRentalService carRentalService;

    @PostMapping("/rent")
    public CarRentalResponseDto rentCar(@RequestBody CarRentalRequestDto carRentalRequestDto){
        return carRentalService.rentCar(carRentalRequestDto);
    }

    @PostMapping("/return")
    public CarReturnResponseDto returnCar(@RequestBody CarReturnRequestDto carReturnRequestDto){
        return carRentalService.returnCar(carReturnRequestDto);
    }
}
