package com.ironhack.padeline.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor

@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
public class Manager extends User {
    private Date bdDate;
    @Max(10)
    @Min(0)
    private int level;
    @OneToMany (cascade = CascadeType.ALL)
    private List<Club> managerClub = new ArrayList<>();

    public Manager(Long id, String name, String username, String password, Collection<Role> roles, Date bdDate, int level, List<Club> managerClub) {
        super(id, name, username, password, roles);
        this.bdDate = bdDate;
        this.level = level;
        this.managerClub = managerClub;
    }
}
