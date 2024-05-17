package com.carrental.carrentalservice.repositories;

import com.carrental.carrentalservice.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    Car findByRegistrationNumber(String registrationNumber);
}
