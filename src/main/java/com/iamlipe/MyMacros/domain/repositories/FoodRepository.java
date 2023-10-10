package com.iamlipe.MyMacros.domain.repositories;

import com.iamlipe.MyMacros.domain.entities.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoodRepository extends JpaRepository<Food, UUID> {
}
