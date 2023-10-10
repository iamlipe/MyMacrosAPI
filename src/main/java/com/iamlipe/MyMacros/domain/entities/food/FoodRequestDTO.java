package com.iamlipe.MyMacros.domain.entities.food;

public record FoodRequestDTO(
        String name,
        Double carbPerGram,
        Double fatPerGram,
        Double fiberPerGram,
        Double kcalPerGram,
        Double protPerGram,
        Double sodiumPerGram
) {
    
}
