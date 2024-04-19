package com.ironhack.padeline.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
//@Table(name = "admin")
@Data
@NoArgsConstructor
public class Admin extends User {
    public Admin(Long id, String name, String username, String password, Collection<Role> roles) {
        super(id, name, username, password, roles);
    }
}
