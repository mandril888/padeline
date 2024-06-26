package com.ironhack.padeline.services.impl;

import com.ironhack.padeline.models.Match;
import com.ironhack.padeline.models.Player;
import com.ironhack.padeline.repositories.PlayerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerServiceTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    private Player player;
    private Match match;

    @BeforeEach
    void setUp() {
        player = new Player(1L, "Player1", "player1", "1234", new ArrayList<>(), new Date(2014, 2, 11), 5);
    }

    @AfterEach
    void tearDown() {
        playerRepository.deleteAll();
    }

    @Test
    void savePlayer() {
        Player newPlayer = playerService.savePlayer(player);
        Optional<Player> playerFound = playerRepository.findById(newPlayer.getId());
        assertEquals(newPlayer.getUsername(), playerFound.get().getUsername());
    }

    @Test
    void saveMatch() {
    }
}