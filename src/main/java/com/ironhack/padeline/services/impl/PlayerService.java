package com.ironhack.padeline.services.impl;

import com.ironhack.padeline.models.Match;
import com.ironhack.padeline.models.Player;
import com.ironhack.padeline.repositories.MatchRepository;
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
    private MatchRepository matchRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public Player savePlayer(Player player) {
        Optional<Player> optionalPlayer = playerRepository.findById(player.getId());
        if (optionalPlayer.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Player with id " + player.getId() + " already exist");

        log.info("Saving new manager {} to the database", player.getName());
        // Encode the player's password for security before saving
        player.setPassword(passwordEncoder.encode(player.getPassword()));
        Player playerSaved = playerRepository.save(player);

        userService.addRoleToUser(playerSaved.getUsername(), "ROLE_MANAGER");

        return playerSaved;
    }

    @Override
    public Player updatePlayer(Long id, Player player) {
        log.info("Updating player with id " + id);
        Optional<Player> playerOld = playerRepository.findById(id);
        if (playerOld.isPresent()) {
            player.setId(id);
            player.setPassword(passwordEncoder.encode(player.getPassword()));
            player.setRoles(playerOld.get().getRoles());
            return playerRepository.save(player);
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Player with id " + id + " doesn't exist");
        }
    }

    @Override
    public Match saveMatch(Match match) {
        Optional<Match> optionalMatch = matchRepository.findById(match.getId());
        if (optionalMatch.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Match with id " + match.getId() + " already exist");

        return matchRepository.save(match);
    }
}
