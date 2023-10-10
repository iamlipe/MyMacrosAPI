package com.iamlipe.MyMacros.infrastructure.services;

import com.iamlipe.MyMacros.domain.entities.meal.Meal;
import com.iamlipe.MyMacros.domain.entities.meal.MealRequestDTO;
import com.iamlipe.MyMacros.domain.entities.user.User;
import com.iamlipe.MyMacros.infrastructure.exceptions.NotFound;
import com.iamlipe.MyMacros.domain.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class MealService {

    @Autowired
    private MealRepository repository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Meal insert(User user, MealRequestDTO data) {
        String name = data.name();
        LocalDateTime time = LocalDateTime.parse(data.time(), formatter);

        Meal meal = new Meal(name, time, user);

        return repository.save(meal);
    }

    public Meal update(UUID mealId, MealRequestDTO data) {
        Meal meal = findById(mealId);

        meal.setName(data.name());
        meal.setTime(LocalDateTime.parse(data.time(), formatter));

        return repository.save(meal);
    }

    public void delete(UUID mealId) {
        Meal meal = findById(mealId);
        repository.delete(meal);
    }

    public Set<Meal> findAllByUser(User user) {
        return repository.findAllByUser(user);
    }

    public Meal findById(UUID id) {
        Optional<Meal> meal = repository.findById(id);
        return meal.orElseThrow(() -> new NotFound(id.toString()));
    }
}
