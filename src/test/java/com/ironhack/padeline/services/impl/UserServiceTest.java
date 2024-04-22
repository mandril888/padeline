package com.ironhack.padeline.services.impl;

import com.ironhack.padeline.models.User;
import com.ironhack.padeline.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    User user;
    User newUser;

    @BeforeEach
    public void setUp() {
        user = new User(1L, "User1", "user1", "1234", new ArrayList<>());
        newUser = userService.saveUser(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void updateUser() {
        user.setName("New name");
        userService.updateUser(newUser.getId(), user);
        User userFound = userService.getUser(newUser.getUsername());
        assertEquals("New name", userFound.getName());
    }

    @Test
    void deleteUser() {
        userService.deleteUser(newUser.getId());
        User userFound = userService.getUser(newUser.getUsername());
        assertNull(userFound);
    }
}