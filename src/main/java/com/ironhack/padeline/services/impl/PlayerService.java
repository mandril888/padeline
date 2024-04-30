package com.ironhack.padeline.services.impl;

import com.ironhack.padeline.models.Player;
import com.ironhack.padeline.repositories.PlayerRepository;
import com.ironhack.padeline.services.interfaces.PlayerServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerService implements PlayerServiceInterface {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Player savePlayer(Player player) {
        Optional<Player> optionalProduct = playerRepository.findById(player.getId());
        if (optionalProduct.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Player with id " + player.getId() + " already exist");

        log.info("Saving new manager {} to the database", player.getName());
        // Encode the manager's password for security before saving
        player.setPassword(passwordEncoder.encode(player.getPassword()));
        return playerRepository.save(player);
    }
}
