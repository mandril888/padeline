package com.ironhack.padeline.services.interfaces;

import com.ironhack.padeline.models.Club;
import com.ironhack.padeline.models.Court;
import com.ironhack.padeline.models.Manager;

public interface ManagerServiceInterface {

    Club saveClub(Club club, Long idManager);

    Court saveCourt(Court court, int idClub);

    Manager updateManager(Long id, Manager manager);
}
