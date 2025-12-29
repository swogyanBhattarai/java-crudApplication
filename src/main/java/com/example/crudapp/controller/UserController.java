package com.example.crudapp.controller;

import com.example.crudapp.dto.UserResponseDTO;
import com.example.crudapp.dto.UserUpdateDTO;
import com.example.crudapp.model.UserModel;
import com.example.crudapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public UserModel create(@RequestBody UserModel user) {
        return userService.create(user);
    }

    @GetMapping("getUser/{id}")
    public UserResponseDTO getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/getAllUsers")
    public List<UserModel> getAll() {
        return userService.getAll();
    }

    @PutMapping("updateUser/{id}")
    public UserUpdateDTO updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO updated) {
        return userService.updateUser(id, updated);
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
