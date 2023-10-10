package com.iamlipe.MyMacros.adapter.controllers;

import com.iamlipe.MyMacros.domain.entities.info.InfoRequestDTO;
import com.iamlipe.MyMacros.domain.entities.info.Info;
import com.iamlipe.MyMacros.domain.entities.user.User;
import com.iamlipe.MyMacros.infrastructure.services.InfoService;
import com.iamlipe.MyMacros.infrastructure.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/{userId}")
    public ResponseEntity<Void> insert(@PathVariable String userId, @RequestBody InfoRequestDTO data) {
        User user = userService.findById(UUID.fromString(userId));
        Info info = infoService.insertInfo(user, data);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(info.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{infoId}")
    public ResponseEntity<Info> update(@PathVariable String infoId, @RequestBody InfoRequestDTO data) {
        Info info = infoService.updateInfo(UUID.fromString(infoId), data);
        return ResponseEntity.ok(info);
    }
}
