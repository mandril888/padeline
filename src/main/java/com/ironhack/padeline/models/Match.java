package com.ironhack.padeline.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "court")
@Data
@NoArgsConstructor
public class Match {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date matchDate;
    @OneToOne
    @JoinColumn(name = "match_court")
    private List<Court> matchCourt = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "match_player")
    private List<Player> matchPlayer = new ArrayList<>();
}
