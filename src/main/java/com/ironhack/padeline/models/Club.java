package com.ironhack.padeline.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "club")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Club {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne
    @JoinColumn(name = "club_address")
    private Address clubAddress;
    @OneToOne
    @JoinColumn(name = "club_manager")
    private Manager clubManager;
    @OneToMany
    @JoinColumn(name = "club_court")
    private List<Court> clubCourt = new ArrayList<>();
}
