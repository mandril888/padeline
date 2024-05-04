package com.ironhack.padeline.models;

import com.ironhack.padeline.enums.Place;
import com.ironhack.padeline.enums.Type;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourtTest {
    @Test
    public void create_court() {
        Court court = new Court(1, "Central", Place.INDOOR, Type.GLASS);
        assertEquals(Place.INDOOR, court.getPlace());
    }
}