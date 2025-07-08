package com.trimblecars.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String type; // OWNER, CUSTOMER, ADMIN
    private String password;
}
