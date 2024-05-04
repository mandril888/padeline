package com.ironhack.padeline.controllers.impl;

import com.ironhack.padeline.models.Club;
import com.ironhack.padeline.models.Court;
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
    public Club saveClub(@RequestBody @Valid Club club, Long idManager) {
        return managerService.saveClub(club, idManager);
    }

    @PostMapping("/courts")
    @ResponseStatus(HttpStatus.CREATED)
    public Court saveCourt(@RequestBody @Valid Court court, int idClub) {
        return managerService.saveCourt(court, idClub);
    }
}
