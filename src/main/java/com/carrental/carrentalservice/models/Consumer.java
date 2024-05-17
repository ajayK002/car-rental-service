package com.carrental.carrentalservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Consumer extends BaseModel{
    private String name;

    private String contactNo;

    @Column(unique = true)
    private String personalIdNo;
}
