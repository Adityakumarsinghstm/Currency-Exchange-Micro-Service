package com.socialMediaApp.controller;

import com.socialMediaApp.customException.UserNotFoundException;
import com.socialMediaApp.dao.UserDaoService;
import com.socialMediaApp.entity.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserResource {
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers()
    {
        return service.findAll();
    }

    @GetMapping("/user/{id}")
    public User retriveUser(@PathVariable int id)
    {
        User user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id : "+id);
        return user;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user)
    {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id)
    {
        service.deleteById(id);
    }
}
