package com.ironhack.padeline.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {

    @Test
    public void create_admin() {
        Admin admin = new Admin(1L, "Admin", "admin", "1234", new ArrayList<>());
        assertEquals("admin", admin.getUsername());
    }
}