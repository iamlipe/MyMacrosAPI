package com.iamlipe.MyMacros.domain.entities.info;

import com.iamlipe.MyMacros.domain.enums.ActivityLevel;
import com.iamlipe.MyMacros.domain.enums.Gender;
import com.iamlipe.MyMacros.domain.enums.Goal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public record InfoRequestDTO(
        Gender gender,
        String birthDate,
        ActivityLevel activityLevel,
        Double height,
        Double weight,
        Goal goal
) {

}
