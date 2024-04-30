package com.ironhack.padeline.controllers.impl;

import com.ironhack.padeline.models.Player;
import com.ironhack.padeline.services.interfaces.PlayerServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    private PlayerServiceInterface playerService;

    @PostMapping("/players")
    @ResponseStatus(HttpStatus.CREATED)
    public Player savePlayer(@RequestBody @Valid Player player) {
        return playerService.savePlayer(player);
    }
}
