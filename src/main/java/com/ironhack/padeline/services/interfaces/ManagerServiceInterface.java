package com.ironhack.padeline.services.interfaces;

import com.ironhack.padeline.models.Club;
import com.ironhack.padeline.models.Court;
import com.ironhack.padeline.models.Manager;

public interface ManagerServiceInterface {

    Club saveClub(Club club, Manager manager);

    Court saveCourt(Court court);
}
