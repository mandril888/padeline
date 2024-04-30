package com.ironhack.padeline.services.impl;

import com.ironhack.padeline.models.Club;
import com.ironhack.padeline.models.Court;
import com.ironhack.padeline.models.Manager;
import com.ironhack.padeline.repositories.ClubRepository;
import com.ironhack.padeline.repositories.CourtRepository;
import com.ironhack.padeline.services.interfaces.ManagerServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManagerService implements ManagerServiceInterface {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private CourtRepository courtRepository;

    @Override
    public Club saveClub(Club club, Manager manager) {
        Optional<Club> optionalClub = clubRepository.findById(club.getId());
        if (optionalClub.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Club with id " + club.getId() + " already exist");

        log.info("Asociating new club {} to the manager", club.getName());
        List clubsList = manager.getManagerClub();
        clubsList.add(club);
        manager.setManagerClub(clubsList);
        log.info("Saving new club {} to the database", club.getName());
        return clubRepository.save(club);
    }

    @Override
    public Court saveCourt(Court court) {
        Optional<Court> optionalCourt = courtRepository.findById(court.getId());
        if (optionalCourt.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Court with id " + court.getId() + " already exist");

        log.info("Saving new court {} to the database", court.getName());
        return courtRepository.save(court);
    }
}
