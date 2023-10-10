package com.iamlipe.MyMacros.domain.entities.user;

import com.iamlipe.MyMacros.domain.entities.info.Info;
import com.iamlipe.MyMacros.domain.entities.mealTime.MealTime;

import java.util.Set;

public record LoginResponseDTO(String name, String email, String phone, String token) {
}
