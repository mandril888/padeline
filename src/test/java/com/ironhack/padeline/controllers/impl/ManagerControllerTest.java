package com.ironhack.padeline.controllers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.padeline.enums.Place;
import com.ironhack.padeline.enums.Type;
import com.ironhack.padeline.models.*;
import com.ironhack.padeline.repositories.ClubRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ManagerControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ClubRepository clubRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @AfterEach
    void tearDown() {
        clubRepository.deleteAll();
    }

    @Test
    void saveClub() throws Exception {
        Manager manager = new Manager(1L, "Manager1", "manager1", "1234", new ArrayList<>(), new Date(2010, 7, 21), 8, new ArrayList<>());
        Address address = new Address(1, "country", "city", "streeet", "number");
        Club club = new Club(1, "Club1", address, manager, new ArrayList<>());
        String body = objectMapper.writeValueAsString(club);
        MvcResult mvcResult = mockMvc.perform(post("/api/clubs")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Club1"));
    }

    @Test
    void saveCourt() throws Exception {
        Court court = new Court(1, "Principal", Place.INDOOR, Type.CEMENT);
        String body = objectMapper.writeValueAsString(court);
        MvcResult mvcResult = mockMvc.perform(post("/api/courts")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Principal"));
    }
}