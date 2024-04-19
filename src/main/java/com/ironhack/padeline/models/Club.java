package com.ironhack.padeline.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    private List<Address> clubAddress = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "club_manager")
    private List<Manager> clubManager = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "club_court")
    private List<Court> clubCourt = new ArrayList<>();
}
