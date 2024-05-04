package com.ironhack.padeline.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private int id;
    @NotNull
    private String name;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "club_address")
    @NotNull
    private Address clubAddress;
    @ManyToOne
    @JoinColumn(name = "club_manager")
    @NotNull
    private Manager clubManager;
    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name = "club_court")
    private List<Court> clubCourt = new ArrayList<>();
}
