package com.ironhack.padeline.controllers.impl;

import com.ironhack.padeline.models.Manager;
import com.ironhack.padeline.services.interfaces.AdminServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminServiceInterface adminService;

    @PostMapping("/managers")
    @ResponseStatus(HttpStatus.CREATED)
    public Manager saveManager(@RequestBody @Valid Manager manager) {
        return adminService.saveManager(manager);
    }
}
