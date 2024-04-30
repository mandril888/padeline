package com.ironhack.padeline.repositories;

import com.ironhack.padeline.models.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository extends JpaRepository<Court, Integer> {
}
