package com.ironhack.padeline.services.impl;

import com.ironhack.padeline.models.Club;
import com.ironhack.padeline.models.Court;
import com.ironhack.padeline.models.Manager;
import com.ironhack.padeline.repositories.ClubRepository;
import com.ironhack.padeline.repositories.CourtRepository;
import com.ironhack.padeline.repositories.ManagerRepository;
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

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Club saveClub(Club club) {
        Optional<Club> optionalClub = clubRepository.findById(club.getId());
        if (optionalClub.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Club with id " + club.getId() + " already exist");

        log.info("Saving new club {} to the database", club.getName());
        Club clubSaved = clubRepository.save(club);

        Optional<Manager> optionalManager = managerRepository.findById(club.getClubManager().getId());
        if (optionalManager.isPresent()) {
            log.info("Associating new club {} to the manager", club.getName());
            List<Club> clubsList = optionalManager.get().getManagerClub();
            clubsList.add(clubSaved);
            managerRepository.save(optionalManager.get());
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Manager with id " + club.getClubManager().getId() + " doesn't exist");
        }

        return clubSaved;
    }

    @Override
    public Court saveCourt(Court court, int idClub) {
        Optional<Court> optionalCourt = courtRepository.findById(court.getId());
        if (optionalCourt.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Court with id " + court.getId() + " already exist");

        log.info("Saving new court {} to the database", court.getName());
        Court courtSaved = courtRepository.save(court);

        Optional<Club> optionalClub = clubRepository.findById(idClub);
        if (optionalClub.isPresent()) {
            log.info("Associating new court {} to the club", court.getName());
            List<Court> clubCourts = optionalClub.get().getClubCourt();
            clubCourts.add(courtSaved);
            clubRepository.save(optionalClub.get());
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Club with id " + idClub + " doesn't exist");
        }

        return courtSaved;
    }

    @Override
    public Manager updateManager(Long id, Manager manager) {
        log.info("Updating user with id " + id);
        Optional<Manager> userOld = managerRepository.findById(id);
        if (userOld.isPresent()) {
            manager.setId(id);
            return managerRepository.save(manager);
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Manager with id " + id + " doesn't exist");
        }
    }
}
