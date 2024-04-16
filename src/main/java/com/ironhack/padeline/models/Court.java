package com.ironhack.padeline.models;

import com.ironhack.padeline.enums.Place;
import com.ironhack.padeline.enums.Type;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "court")
@Data
@NoArgsConstructor
public class Court {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Place place;
    @Enumerated(EnumType.STRING)
    private Type type;
    private boolean isBooked;
}
