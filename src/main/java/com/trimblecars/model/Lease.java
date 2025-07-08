package com.trimblecars.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Data
public class Lease {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String carId;
    private String customerId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status; // ACTIVE, COMPLETED
}
