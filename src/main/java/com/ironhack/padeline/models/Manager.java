package com.ironhack.padeline.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends User {
    private Date bdDate;
    @Max(10)
    @Min(0)
    private int level;
    @OneToMany
    @JoinColumn(name = "manager_club")
    private List<Club> managerClub = new ArrayList<>();
}
