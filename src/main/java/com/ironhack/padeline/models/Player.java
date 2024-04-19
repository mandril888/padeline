package com.ironhack.padeline.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player extends User {
    private Date bdDate;
    @Max(10)
    @Min(0)
    private int level;
    private Date blockedDate;
}
