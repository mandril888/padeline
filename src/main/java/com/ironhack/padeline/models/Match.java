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
public class Match {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "match_court")
    private Court matchCourt;
    @OneToMany
    @JoinColumn(name = "match_player")
    private Player matvhPlayer;
    private boolean isFull;
}
