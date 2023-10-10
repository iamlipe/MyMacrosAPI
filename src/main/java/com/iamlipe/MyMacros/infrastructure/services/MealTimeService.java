package com.iamlipe.MyMacros.infrastructure.services;

import com.iamlipe.MyMacros.domain.entities.mealTime.MealTime;
import com.iamlipe.MyMacros.domain.entities.mealTime.MealTimeRequestDTO;
import com.iamlipe.MyMacros.domain.entities.user.User;
import com.iamlipe.MyMacros.infrastructure.exceptions.NotFound;
import com.iamlipe.MyMacros.domain.repositories.MealTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MealTimeService {

    @Autowired
    private MealTimeRepository repository;

    public MealTime insertMealTime(User user, MealTimeRequestDTO data) {
        String name = data.name();
        Integer hours = data.hours();
        Integer minutes = data.minutes();

        MealTime mealTime = new MealTime(name, hours, minutes, user);

        return repository.save(mealTime);
    }

    public void deleteMealTime(UUID id) {
        MealTime mealTime = findById(id);
        repository.delete(mealTime);
    }

    public MealTime updateMealTime(UUID mealTimeId, MealTimeRequestDTO data) {
        MealTime mealTime = findById(mealTimeId);

        mealTime.setName(data.name());
        mealTime.setHours(data.hours());
        mealTime.setMinutes(data.minutes());

        return repository.save(mealTime);
    }

    public MealTime findById(UUID id) {
        Optional<MealTime> mealTime = repository.findById(id);
        return mealTime.orElseThrow(() -> new NotFound(id.toString()));
    }
}
