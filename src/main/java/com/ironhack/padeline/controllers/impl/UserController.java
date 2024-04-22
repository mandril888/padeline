package com.ironhack.padeline.controllers.impl;

import com.ironhack.padeline.models.User;
import com.ironhack.padeline.services.interfaces.UserServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTful API for User management
 */
@RestController
@RequestMapping("/api")
public class UserController {

    /**
     * User service for accessing user data
     */
    @Autowired
    private UserServiceInterface userService;

    /**
     * Get a list of all users
     *
     * @return list of all users
     */
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * Save a new user
     *
     * @param user the user to be saved
     */
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody @Valid User user) {
        userService.saveUser(user);
    }

    @PatchMapping("/users/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable(name="id") Long id, @RequestBody @Valid User user) {
        userService.updateUser(id, user);
    }
}
