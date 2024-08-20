package com.safosamson.runnerz.run;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(Integer id,
                  @NotNull
                  String title,
                  LocalDateTime startedOn,
                  LocalDateTime completedOn,
                  @Positive
                  Integer miles,
                  Location location ) {
    public Run{
        if(!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("completedOn must be after startedOn");
        }
    }
}
