package com.iamlipe.MyMacros.domain.entities.meal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iamlipe.MyMacros.domain.entities.mealFood.MealFood;
import com.iamlipe.MyMacros.domain.entities.user.User;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Table(name = "tb_meal")
@EqualsAndHashCode(of = "id")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private LocalDateTime time;

    @OneToMany(mappedBy = "id.meal")
    private Set<MealFood> foods = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    private User user;

    public Meal() {
    }

    public Meal(String name, LocalDateTime time, User user) {
        this.name = name;
        this.time = time;
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
