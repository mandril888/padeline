package com.ironhack.padeline.controllers.impl;

import com.ironhack.padeline.models.Club;
import com.ironhack.padeline.models.Manager;
import com.ironhack.padeline.services.interfaces.ManagerServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ManagerController {

    @Autowired
    private ManagerServiceInterface managerService;

    @PostMapping("/clubs")
    @ResponseStatus(HttpStatus.CREATED)
    public Club saveClub(@RequestBody @Valid Club club, Manager manager) {
        return managerService.saveClub(club, manager);
    }
}
