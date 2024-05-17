package com.carrental.carrentalservice.repositories;

import com.carrental.carrentalservice.models.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,Long> {
    Optional<Consumer> findByPersonalIdNo(String personalIdNo);
}
