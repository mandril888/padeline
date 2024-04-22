package com.ironhack.padeline.services.impl;

import com.ironhack.padeline.models.Manager;
import com.ironhack.padeline.repositories.ManagerRepository;
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
class AdminServiceTest {

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    AdminService adminService;

    Manager manager;

    @BeforeEach
    public void setUp() {
        manager = new Manager(1L, "Manager1", "manager1", "1234", new ArrayList<>(), new Date(2010, 7, 21), 8, new ArrayList<>());
    }

    @AfterEach
    void tearDown() {
        managerRepository.deleteAll();
    }

    @Test
    void saveManager() {
        Manager newManager = adminService.saveManager(manager);
        Optional<Manager> managerFound = managerRepository.findById(newManager.getId());
        assertEquals(newManager.getUsername(), managerFound.get().getUsername());
    }
}