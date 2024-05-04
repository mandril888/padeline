package com.ironhack.padeline.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public class Club {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "club_address")
    @NotNull
    private Address clubAddress;
    @ManyToOne
    @JoinColumn(name = "club_manager")
    private Manager clubManager;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "club_court")
    private List<Court> clubCourt = new ArrayList<>();
}
