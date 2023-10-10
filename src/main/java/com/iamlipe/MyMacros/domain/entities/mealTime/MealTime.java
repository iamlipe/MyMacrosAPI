package com.iamlipe.MyMacros.domain.entities.mealTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iamlipe.MyMacros.domain.entities.user.User;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
@Table(name = "tb_meal_time")
@EqualsAndHashCode(of = "id")
public class MealTime {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Integer hours;
    private Integer minutes;

    @JsonIgnore
    @ManyToOne
    private User user;

    public MealTime() {
    }

    public MealTime(String name, Integer hours, Integer minutes, User user) {
        this.name = name;
        this.hours = hours;
        this.minutes = minutes;
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }
}
