package com.carrental.carrentalservice.repositories;

import com.carrental.carrentalservice.models.Car;
import com.carrental.carrentalservice.models.Consumer;
import com.carrental.carrentalservice.models.ConsumerCarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerCarRentalRepository extends JpaRepository<ConsumerCarRental,Long>{
    ConsumerCarRental findByCar_IdAndReturnedOnNull(Long carId);
}
