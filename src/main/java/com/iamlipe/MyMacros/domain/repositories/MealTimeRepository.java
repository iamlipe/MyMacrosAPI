package com.iamlipe.MyMacros.domain.repositories;

import com.iamlipe.MyMacros.domain.entities.mealTime.MealTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MealTimeRepository extends JpaRepository<MealTime, UUID> {
}
