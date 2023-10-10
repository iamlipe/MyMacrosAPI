package com.iamlipe.MyMacros.infrastructure.services;

import com.iamlipe.MyMacros.domain.entities.user.LoginRequestDTO;
import com.iamlipe.MyMacros.domain.entities.user.LoginResponseDTO;
import com.iamlipe.MyMacros.domain.entities.user.RegisterRequestDTO;
import com.iamlipe.MyMacros.domain.entities.user.User;
import com.iamlipe.MyMacros.infrastructure.exceptions.*;
import com.iamlipe.MyMacros.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public User register(RegisterRequestDTO data) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(data.email());

        boolean emailAlreadyRegistered = repository.existsByEmail(data.email());

        if (emailAlreadyRegistered) throw new EmailAlreadyRegistered();
        if (data.name().length() < 3) throw new InvalidNameLength();
        if (data.password().length() < 8) throw new InvalidPasswordLength();
        if (!matcher.matches()) throw new InvalidEmailFormat();

        String encyptedPassword = new BCryptPasswordEncoder().encode(data.password());

        User user = new User(data.name(), data.email(), data.phone(), encyptedPassword);

        return repository.save(user);
    }

    public LoginResponseDTO login(LoginRequestDTO data, String token) {
        User user = (User) repository.findByEmail(data.email());

        String name = user.getName();
        String email = user.getEmail();
        String phone = user.getPhone();

        return new LoginResponseDTO(name, email, phone, token);
    }

    public User findById(UUID id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new NotFound(id.toString()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }
}
