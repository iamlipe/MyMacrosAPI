package com.iamlipe.MyMacros.domain.entities.mealFood;

import com.iamlipe.MyMacros.domain.entities.food.Food;
import com.iamlipe.MyMacros.domain.entities.meal.Meal;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_meal_food")
@EqualsAndHashCode(of = "id")
public class MealFood {

    @EmbeddedId
    private MealFoodPk id = new MealFoodPk();
    private Double grams;

    public MealFood() {
    }

    public MealFood(Meal meal, Food food, Double grams) {
        super();
        setMeal(meal);
        setFood(food);
        this.grams = grams;
    }

    public Meal getMeal() {
        return id.getMeal();
    }

    public void setMeal(Meal meal) {
        id.setMeal(meal);
    }

    public Food getFood() {
        return id.getFood();
    }

    public void setFood(Food food) {
        id.setFood(food);
    }

    public Double getGrams() {
        return grams;
    }

    public void setGrams(Double grams) {
        this.grams = grams;
    }
}
