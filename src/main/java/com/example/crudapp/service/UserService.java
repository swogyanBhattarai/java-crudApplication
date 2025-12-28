package com.example.crudapp.service;

import com.example.crudapp.model.UserModel;
import com.example.crudapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    // Initial link to database created
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a user
    public UserModel create(UserModel user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    // Get user by id
    public UserModel getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Update users
    public UserModel updateUser(Long id, UserModel updated) {
        UserModel user = getById(id);
        user.setName(updated.getName());
        user.setEmail(updated.getEmail());
        return userRepository.save(user);
    }

    // Delete user
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
