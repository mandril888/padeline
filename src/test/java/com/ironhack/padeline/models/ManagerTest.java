package com.ironhack.padeline.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    public void create_manager() {
        Manager manager= new Manager(1L, "Manager1", "manager1", "1234", new ArrayList<>(), new Date(2010, 7, 21), 8, new ArrayList<>());;
        assertEquals(8, manager.getLevel());
    }

}