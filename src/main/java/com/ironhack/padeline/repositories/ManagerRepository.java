package com.ironhack.padeline.repositories;

import com.ironhack.padeline.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {

    Manager saveManager(Manager manager);
}
