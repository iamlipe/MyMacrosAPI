package com.iamlipe.MyMacros.adapter.controllers;

import com.iamlipe.MyMacros.domain.entities.user.LoginRequestDTO;
import com.iamlipe.MyMacros.domain.entities.user.LoginResponseDTO;
import com.iamlipe.MyMacros.domain.entities.user.RegisterRequestDTO;
import com.iamlipe.MyMacros.domain.entities.user.User;
import com.iamlipe.MyMacros.infrastructure.services.SecurityFilter;
import com.iamlipe.MyMacros.infrastructure.services.TokenService;
import com.iamlipe.MyMacros.infrastructure.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/auth")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SecurityFilter securityFilter;


    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequestDTO data) {
        User createdUser = service.register(data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO data) {
        Authentication usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        authenticationManager.authenticate(usernamePassword);
        String token = tokenService.generateToken(data.email());
        LoginResponseDTO loginResponseDTO = service.login(data, token);
        return ResponseEntity.ok(loginResponseDTO);
    }
}
