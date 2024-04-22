package com.ironhack.padeline.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void create_player() {
        Player player = new Player(null, "Player1", "player1", "1234", new ArrayList<>(), new Date(2014, 2, 11), 5);
        assertEquals("1234", player.getPassword());
    }
}