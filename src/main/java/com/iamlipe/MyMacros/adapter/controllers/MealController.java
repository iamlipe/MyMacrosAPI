package com.iamlipe.MyMacros.adapter.controllers;

import com.iamlipe.MyMacros.domain.entities.meal.MealRequestDTO;
import com.iamlipe.MyMacros.domain.entities.meal.Meal;
import com.iamlipe.MyMacros.domain.entities.user.User;
import com.iamlipe.MyMacros.infrastructure.services.MealService;
import com.iamlipe.MyMacros.infrastructure.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(value = "/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/{userId}")
    public ResponseEntity<Void> insert(@PathVariable String userId, @RequestBody MealRequestDTO data) {
        User user = userService.findById(UUID.fromString(userId));
        Meal meal = mealService.insert(user, data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(meal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{mealId}")
    public ResponseEntity<Meal> update(@PathVariable String mealId, @RequestBody MealRequestDTO data) {
        Meal meal = mealService.update(UUID.fromString(mealId), data);
        return ResponseEntity.ok(meal);
    }

    @DeleteMapping(value = "/{mealId}")
    public ResponseEntity<Void> delete(@PathVariable String mealId) {
        mealService.delete(UUID.fromString(mealId));
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<Set<Meal>> findAllByUser(@PathVariable String userId) {
        User user = userService.findById(UUID.fromString(userId));
        Set<Meal> meals = mealService.findAllByUser(user);
        return ResponseEntity.ok(meals);
    }
}
