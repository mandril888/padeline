package com.ironhack.padeline.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ClubTest {

    private Manager manager = new Manager(1L, "Manager1", "manager1", "1234", new ArrayList<>(), new Date(2010, 7, 21), 8, new ArrayList<>());;
    private Address address = new Address(1, "Spain", "Barcelona", "meridiana", "81-83");

    @Test
    public void create_club() {
        Club club = new Club(1, "Top Club", address, manager, new ArrayList<>());
        assertEquals("Top Club", club.getName());
    }

}