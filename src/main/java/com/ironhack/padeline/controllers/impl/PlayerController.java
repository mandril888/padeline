package com.ironhack.padeline.controllers.impl;

import com.ironhack.padeline.models.Match;
import com.ironhack.padeline.models.Player;
import com.ironhack.padeline.models.User;
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

    @PatchMapping("/players/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Player updatePlayer(@PathVariable(name="id") Long id, @RequestBody @Valid Player player) {
        return playerService.updatePlayer(id, player);
    }

    @PostMapping("/matches")
    @ResponseStatus(HttpStatus.CREATED)
    public Match saveMatch(@RequestBody @Valid Match match) {
        return playerService.saveMatch(match);
    }
}
