package com.iamlipe.MyMacros.infrastructure.services;

import com.iamlipe.MyMacros.domain.entities.food.Food;
import com.iamlipe.MyMacros.domain.entities.food.FoodRequestDTO;
import com.iamlipe.MyMacros.infrastructure.exceptions.NotFound;
import com.iamlipe.MyMacros.domain.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    public Food insert(FoodRequestDTO data) {
        String name = data.name();
        Double carb = data.carbPerGram();
        Double fat = data.fatPerGram();
        Double fiber = data.fiberPerGram();
        Double kcal = data.kcalPerGram();
        Double prot = data.protPerGram();
        Double sodium = data.sodiumPerGram();

        Food food = new Food(name, carb, fat, fiber, kcal, prot, sodium);

        return repository.save(food);
    }

    public List<Food> findAll() {
        return repository.findAll();
    }

    public Food findById(UUID id) {
        Optional<Food> food = repository.findById(id);
        return food.orElseThrow(() -> new NotFound(id.toString()));
    }
}
