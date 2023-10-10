package com.iamlipe.MyMacros.adapter.controllers;

import com.iamlipe.MyMacros.domain.entities.mealTime.MealTimeRequestDTO;
import com.iamlipe.MyMacros.domain.entities.mealTime.MealTime;
import com.iamlipe.MyMacros.domain.entities.user.User;
import com.iamlipe.MyMacros.infrastructure.services.MealTimeService;
import com.iamlipe.MyMacros.infrastructure.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/meal-time")
public class MealTimeController {

    @Autowired
    private MealTimeService mealTimeService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/{userId}")
    public ResponseEntity<Void> insert(@PathVariable String userId, @RequestBody MealTimeRequestDTO data) {
        User user = userService.findById(UUID.fromString(userId));
        MealTime mealTime = mealTimeService.insertMealTime(user, data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mealTime.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{mealTimeId}")
    public ResponseEntity<MealTime> update(@PathVariable String mealTimeId, @RequestBody MealTimeRequestDTO data) {
        MealTime mealTime = mealTimeService.updateMealTime(UUID.fromString(mealTimeId), data);
        return ResponseEntity.ok(mealTime);
    }

    @DeleteMapping(value = "/{mealTimeId}")
    public ResponseEntity<Void> delete(@PathVariable String mealTimeId) {
        mealTimeService.deleteMealTime(UUID.fromString(mealTimeId));
        return ResponseEntity.noContent().build();
    }
}
