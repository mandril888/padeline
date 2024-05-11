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
    private int id;
    @NotNull
    private Date matchDate;
    @OneToOne
    @JoinColumn(name = "match_game_court")
    @NotNull
    private Court matchGameCourt;
    @ManyToMany (cascade = CascadeType.MERGE)
    @JoinColumn(name = "match_game_user")
    private List<Player> matchGameUser = new ArrayList<>();
}
