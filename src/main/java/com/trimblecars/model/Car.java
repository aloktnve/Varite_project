package com.trimblecars.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String variant;
    private String licensePlate;
    private String ownerId;
    private String status; // IDEAL, ON_LEASE, ON_SERVICE
}
