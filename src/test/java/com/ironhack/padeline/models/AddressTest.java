package com.ironhack.padeline.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    public void create_address() {
        Address address = new Address(1, "Spain", "Barcelona", "meridiana", "81-83");
        assertEquals("Barcelona", address.getCity());
    }
}