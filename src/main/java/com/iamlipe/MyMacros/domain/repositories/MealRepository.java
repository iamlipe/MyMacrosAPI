package com.iamlipe.MyMacros.domain.repositories;

import com.iamlipe.MyMacros.domain.entities.meal.Meal;
import com.iamlipe.MyMacros.domain.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface MealRepository extends JpaRepository<Meal, UUID> {
    public Set<Meal> findAllByUser(User user);
}
