package com.ironhack.padeline.services.impl;

import com.ironhack.padeline.models.Manager;
import com.ironhack.padeline.repositories.ManagerRepository;
import com.ironhack.padeline.services.interfaces.AdminServiceInterface;
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
public class AdminService implements AdminServiceInterface {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Manager saveManager(Manager manager) {
        Optional<Manager> optionalProduct = managerRepository.findById(manager.getId());
        if (optionalProduct.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Manager with id " + manager.getId() + " already exist");

        log.info("Saving new manager {} to the database", manager.getName());
        // Encode the manager's password for security before saving
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        return managerRepository.save(manager);
    }
}
