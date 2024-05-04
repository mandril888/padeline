package com.ironhack.padeline.services.impl;

import com.ironhack.padeline.enums.Place;
import com.ironhack.padeline.enums.Type;
import com.ironhack.padeline.models.Address;
import com.ironhack.padeline.models.Club;
import com.ironhack.padeline.models.Court;
import com.ironhack.padeline.models.Manager;
import com.ironhack.padeline.repositories.ClubRepository;
import com.ironhack.padeline.repositories.CourtRepository;
import com.ironhack.padeline.repositories.ManagerRepository;
import com.ironhack.padeline.repositories.UserRepository;
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
class ManagerServiceTest {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private CourtRepository courtRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ManagerService managerService;

    private Manager manager;
    private Club club;
    private Address address;
    private Court court;

    @BeforeEach
    public void setUp() {
        manager = new Manager(1L, "Manager1", "manager1", "1234", new ArrayList<>(), new Date(2010, 7, 21), 8, new ArrayList<>());
        Manager newManager = adminService.saveManager(manager);
        address = new Address(1, "country", "city", "streeet", "number");
        club = new Club(1, "Club1", address, manager, new ArrayList<>());
        court = new Court(1, "Principal", Place.INDOOR, Type.CEMENT);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
        clubRepository.deleteAll();
    }

    @Test
    void saveClub_Database() {
        Club newClub = managerService.saveClub(club, manager.getId());
        Optional<Club> clubFound = clubRepository.findById(newClub.getId());
        assertEquals(newClub.getName(), clubFound.get().getName());
    }

    @Test
    void saveClub_Manager() {
        Club newClub = managerService.saveClub(club, manager.getId());
        Optional<Manager> managerFound = managerRepository.findById(manager.getId());
        assertEquals(newClub.getId(), managerFound.get().getManagerClub().get(0).getId());
    }

    @Test
    void saveCourt_Database() {
        Club newClub = managerService.saveClub(club, manager.getId());
        Court newCourt = managerService.saveCourt(court, newClub.getId());
        Optional<Court> courtFound = courtRepository.findById(newCourt.getId());
        assertEquals(newCourt.getName(), courtFound.get().getName());
    }

    @Test
    void saveCourt_Club() {
        Club newClub = managerService.saveClub(club, manager.getId());
        Court newCourt = managerService.saveCourt(court, newClub.getId());
        assertEquals(newClub.getClubCourt().size(), 1);
    }

    // TODO: test updateManager()
}