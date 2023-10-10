package com.iamlipe.MyMacros.infrastructure.services;

import com.iamlipe.MyMacros.domain.entities.food.Food;
import com.iamlipe.MyMacros.domain.entities.meal.Meal;
import com.iamlipe.MyMacros.domain.entities.mealFood.MealFood;
import com.iamlipe.MyMacros.domain.entities.mealFood.MealFoodRequestDTO;
import com.iamlipe.MyMacros.domain.repositories.MealFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealFoodService {

    @Autowired
    private MealFoodRepository repository;

    public MealFood insert(Meal meal, Food food, MealFoodRequestDTO data) {
        Double grams = data.grams();

        MealFood mealFood = new MealFood(meal, food, grams);

        return repository.save(mealFood);
    }

    public MealFood update(Meal meal, Food food, MealFoodRequestDTO data) {
        MealFood mealFood = findByMealAndFood(meal, food);

        mealFood.setGrams(data.grams());

        return repository.save(mealFood);
    }

    public void delete(Meal meal, Food food) {
        MealFood mealFood = findByMealAndFood(meal, food);
        repository.delete(mealFood);
    }

    public MealFood findByMealAndFood(Meal meal, Food food) {
        return repository.findByIdMealAndIdFood(meal, food).get(0);
    }
}
