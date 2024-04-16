package com.ironhack.padeline.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "court")
@Data
@NoArgsConstructor
public class Club {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne
    @JoinColumn(name = "club_address")
    private Address clubAddress;
    private Manager manager;
    @OneToMany
    @JoinColumn(name = "club_court")
    private Court clubCourt;
}
