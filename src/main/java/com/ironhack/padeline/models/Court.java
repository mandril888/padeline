package com.ironhack.padeline.models;

import com.ironhack.padeline.enums.Place;
import com.ironhack.padeline.enums.Type;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "court")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Court {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;
    @NotNull
    private String name;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Place place;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;
}
