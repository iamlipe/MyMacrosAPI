package com.iamlipe.MyMacros.adapter.controllers;

import com.iamlipe.MyMacros.domain.entities.food.FoodRequestDTO;
import com.iamlipe.MyMacros.domain.entities.food.Food;
import com.iamlipe.MyMacros.infrastructure.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/foods")
public class FoodController {

    @Autowired
    private FoodService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody FoodRequestDTO data) {
        Food food = service.insert(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(food.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Food>> findAll() {
        List<Food> foods = service.findAll();
        return ResponseEntity.ok(foods);
    }

    @GetMapping(value = "/{foodId}")
    public ResponseEntity<Food> findById(@PathVariable String foodId) {
        Food food = service.findById(UUID.fromString(foodId));
        return ResponseEntity.ok(food);
    }

}
