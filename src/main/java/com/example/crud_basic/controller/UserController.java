package com.example.crud_basic.controller;

import com.example.crud_basic.Entity.User;
import com.example.crud_basic.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entities")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAllEntities() {
        return service.getAllEntities();
    }

    @GetMapping("/{id}")
    public User getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }

    @PostMapping
    public User createEntity(@RequestBody User user) {
        return service.createEntity(user);
    }

    @PutMapping("/{id}")
    public User updateEntity(@PathVariable Long id, @RequestBody User user) {
        return service.updateEntity(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteEntity(@PathVariable Long id) {
        service.deleteEntity(id);
    }
}
