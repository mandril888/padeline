package com.ironhack.padeline.controllers.impl;

import com.ironhack.padeline.dtos.RoleToUserDTO;
import com.ironhack.padeline.controllers.interfaces.RoleControllerInterface;
import com.ironhack.padeline.models.Role;
import com.ironhack.padeline.services.interfaces.UserServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * RESTful API for Role management
 */
@RestController
@RequestMapping("/api")
public class RoleController implements RoleControllerInterface {

    /**
     * User service for accessing user data
     */
    @Autowired
    private UserServiceInterface userService;

    /**
     * Save a new role
     *
     * @param role role to be saved
     */
    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody @Valid Role role) {
        userService.saveRole(role);
    }

    /**
     * Add a role to a user
     *
     * @param roleToUserDTO DTO containing the username and role name
     */
    @PostMapping("/roles/addtouser")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRoleToUser(@RequestBody @Valid RoleToUserDTO roleToUserDTO) {
        userService.addRoleToUser(roleToUserDTO.getUsername(), roleToUserDTO.getRoleName());
    }
}
