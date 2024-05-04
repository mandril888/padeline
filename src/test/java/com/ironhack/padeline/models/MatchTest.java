package com.ironhack.padeline.models;

import com.ironhack.padeline.enums.Place;
import com.ironhack.padeline.enums.Type;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {
    private Court court = new Court(1, "Central", Place.INDOOR, Type.GLASS);

    @Test
    void create_match() {
        Match match = new Match(1, new Date(2024, 2, 11), court, new ArrayList<>());
        assertEquals(court.getName(), match.getMatchCourt().getName());
    }
}