package com.ironhack.padeline.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "match_game")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;
    @NotNull
    private Date matchDate;
    @OneToOne
    @JoinColumn(name = "match_game_court")
    @NotNull
    private Court matchCourt;
    @OneToMany
    @JoinColumn(name = "match_game_player")
    private List<Player> matchPlayer = new ArrayList<>();
}
