package com.wipro.carms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Car_Registration_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRegistrationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Registration_Number")
    private String registrationNumber;
    @Column(name="Registration_Date")
    private String registrationDate;
}
