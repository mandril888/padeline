package com.ironhack.padeline.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Player extends User {
    private Date bdDate;
    @Max(10)
    @Min(0)
    private int level;
    private Date blockedDate;

    public Player(Long id, String name, String username, String password, Collection<Role> roles, Date bdDate, int level) {
        super(id, name, username, password, roles);
        this.bdDate = bdDate;
        this.level = level;
    }
}
