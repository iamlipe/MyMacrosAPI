package com.iamlipe.MyMacros.adapter.controllers;

import com.iamlipe.MyMacros.domain.entities.mealFood.MealFoodRequestDTO;
import com.iamlipe.MyMacros.domain.entities.food.Food;
import com.iamlipe.MyMacros.domain.entities.meal.Meal;
import com.iamlipe.MyMacros.domain.entities.mealFood.MealFood;
import com.iamlipe.MyMacros.infrastructure.services.FoodService;
import com.iamlipe.MyMacros.infrastructure.services.MealFoodService;
import com.iamlipe.MyMacros.infrastructure.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/meal-food")
public class MealFoodController {

    @Autowired
    private MealFoodService mealFoodService;

    @Autowired
    private MealService mealService;

    @Autowired
    private FoodService foodService;

    @PostMapping(value = "/{mealId}/{foodId}")
    public ResponseEntity<Void> insert(@PathVariable String mealId, @PathVariable String foodId, @RequestBody MealFoodRequestDTO data) {
        Meal meal = mealService.findById(UUID.fromString(mealId));
        Food food = foodService.findById(UUID.fromString(foodId));
        MealFood mealFood = mealFoodService.insert(meal, food, data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mealFood.getMeal().getId() + "/" + mealFood.getFood().getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{mealId}/{foodId}")
    public ResponseEntity<MealFood> update(@PathVariable String mealId, @PathVariable String foodId, @RequestBody MealFoodRequestDTO data) {
        Meal meal = mealService.findById(UUID.fromString(mealId));
        Food food = foodService.findById(UUID.fromString(foodId));
        MealFood mealFood = mealFoodService.update(meal, food, data);
        return ResponseEntity.ok(mealFood);
    }

    @DeleteMapping(value = "/{mealId}/{foodId}")
    public ResponseEntity<Void> delete(@PathVariable String mealId, @PathVariable String foodId) {
        Meal meal = mealService.findById(UUID.fromString(mealId));
        Food food = foodService.findById(UUID.fromString(foodId));
        mealFoodService.delete(meal, food);
        return ResponseEntity.noContent().build();
    }
}
