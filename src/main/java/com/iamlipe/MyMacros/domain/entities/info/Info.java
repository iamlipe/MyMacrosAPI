package com.iamlipe.MyMacros.domain.entities.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iamlipe.MyMacros.domain.entities.user.User;
import com.iamlipe.MyMacros.domain.enums.ActivityLevel;
import com.iamlipe.MyMacros.domain.enums.Gender;
import com.iamlipe.MyMacros.domain.enums.Goal;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Table(name = "tb_info")
@EqualsAndHashCode(of = "id")
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Gender gender;
    private LocalDate birthDate;
    private ActivityLevel activityLevel;
    private Double height;
    private Double weight;
    private Goal goal;

    @JsonIgnore
    @OneToOne
    @MapsId
    private User user;

    public Info() {
    }

    public Info(Gender gender, LocalDate birthDate, ActivityLevel activityLevel, Double height, Double weight, Goal goal, User user) {
        this.gender = gender;
        this.birthDate = birthDate;
        this.activityLevel = activityLevel;
        this.height = height;
        this.weight = weight;
        this.goal = goal;
        this.user = user;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
