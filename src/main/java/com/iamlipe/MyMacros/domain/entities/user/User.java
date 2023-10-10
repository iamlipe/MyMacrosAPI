package com.iamlipe.MyMacros.domain.entities.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iamlipe.MyMacros.domain.entities.meal.Meal;
import com.iamlipe.MyMacros.domain.entities.mealTime.MealTime;
import com.iamlipe.MyMacros.domain.entities.info.Info;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Getter
@Table(name = "tb_user")
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Info info;

    @OneToMany(mappedBy = "user")
    private Set<MealTime> mealTimes = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Meal> meals = new HashSet<>();

    public User() {
    }

    public User(String name, String email, String phone, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
