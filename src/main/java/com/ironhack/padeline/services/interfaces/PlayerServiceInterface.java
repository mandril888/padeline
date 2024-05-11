package com.ironhack.padeline.services.interfaces;

import com.ironhack.padeline.models.Match;
import com.ironhack.padeline.models.Player;
import com.ironhack.padeline.models.User;

import java.util.List;

public interface PlayerServiceInterface {

    Player savePlayer(Player player);

    Player updatePlayer(Long id, Player player);

    Match saveMatch(Match match);

    List<User> getPlayers();
}
