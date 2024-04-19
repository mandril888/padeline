package com.ironhack.padeline.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String country;
    private String city;
    private String street;
    private String number;
}
