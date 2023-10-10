package com.iamlipe.MyMacros.domain.entities.food;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iamlipe.MyMacros.domain.entities.mealFood.MealFood;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;

@Entity
@Getter
@Table(name = "tb_food")
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Double carbPerGram;
    private Double fatPerGram;
    private Double fiberPerGram;
    private Double kcalPerGram;
    private Double protPerGram;
    private Double sodiumPerGram;

    @JsonIgnore
    @OneToMany(mappedBy = "id.food")
    private Set<MealFood> meals = new HashSet<>();

    public Food() {
    }

    public Food(String name, Double carbPerGram, Double fatPerGram, Double fiberPerGram, Double kcalPerGram, Double protPerGram, Double sodiumPerGram) {
        this.name = name;
        this.carbPerGram = carbPerGram;
        this.fatPerGram = fatPerGram;
        this.fiberPerGram = fiberPerGram;
        this.kcalPerGram = kcalPerGram;
        this.protPerGram = protPerGram;
        this.sodiumPerGram = sodiumPerGram;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCarbPerGram(Double carbPerGram) {
        this.carbPerGram = carbPerGram;
    }

    public void setFatPerGram(Double fatPerGram) {
        this.fatPerGram = fatPerGram;
    }

    public void setFiberPerGram(Double fiberPerGram) {
        this.fiberPerGram = fiberPerGram;
    }

    public void setKcalPerGram(Double kcalPerGram) {
        this.kcalPerGram = kcalPerGram;
    }

    public void setProtPerGram(Double protPerGram) {
        this.protPerGram = protPerGram;
    }

    public void setSodiumPerGram(Double sodiumPerGram) {
        this.sodiumPerGram = sodiumPerGram;
    }
}
