package com.iamlipe.MyMacros.domain.entities.meal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record MealRequestDTO(String name, String time) {
    // Você não precisa de construtores explícitos, getters ou setters.
    // O registro já cria automaticamente um construtor e métodos getters.

//    public Meal toMeal() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//        return new Meal(name, LocalDateTime.parse(time, formatter));
//    }
}
