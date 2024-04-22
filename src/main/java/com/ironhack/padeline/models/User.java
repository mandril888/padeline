package com.ironhack.padeline.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Collection;

import static jakarta.persistence.FetchType.EAGER;

/**
 * Entity class for representing a User in the database
 */
@SuperBuilder
@Entity
@Data
@Table(
        name = "user",
        uniqueConstraints=
            @UniqueConstraint(columnNames={"username"})
)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * The unique identifier for the user
     */
    @Id
    /**
     * The id field is generated automatically by the database
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    /**
     * The name of the user
     */
    @NotNull
    private String name;

    /**
     * The username used to log in
     */
    @Setter(AccessLevel.NONE)
    @NotNull
    private String username;

    /**
     * The password used to log in
     */
    @NotNull
    private String password;

    /**
     * The roles that the user has
     */
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
