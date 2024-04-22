package com.ironhack.padeline.services.impl;

import com.ironhack.padeline.models.Manager;
import com.ironhack.padeline.repositories.AdminRepository;
import com.ironhack.padeline.repositories.ManagerRepository;
import com.ironhack.padeline.services.interfaces.AdminServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        log.info("Saving new manager {} to the database", manager.getName());
        // Encode the manager's password for security before saving
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        return managerRepository.save(manager);
    }
}