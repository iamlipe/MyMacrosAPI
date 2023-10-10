package com.iamlipe.MyMacros.domain.repositories;

import com.iamlipe.MyMacros.domain.entities.food.Food;
import com.iamlipe.MyMacros.domain.entities.meal.Meal;
import com.iamlipe.MyMacros.domain.entities.mealFood.MealFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MealFoodRepository extends JpaRepository<MealFood, UUID> {
    List<MealFood> findByIdMealAndIdFood(Meal meal, Food food);
}
