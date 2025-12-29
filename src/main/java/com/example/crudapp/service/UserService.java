package com.example.crudapp.service;

import com.example.crudapp.dto.OrderResponseDTO;
import com.example.crudapp.dto.UserResponseDTO;
import com.example.crudapp.dto.UserUpdateDTO;
import com.example.crudapp.model.UserModel;
import com.example.crudapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    // Initial link to a database created
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a user
    public UserModel create(UserModel user) {
        LocalDateTime now = LocalDateTime.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        return userRepository.save(user);
    }

    // Get all users
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    // Get user by id
    public UserResponseDTO getById(Long id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());

        List<OrderResponseDTO> orders = user.getOrders().stream().map(
                order -> {
                    OrderResponseDTO oDto = new OrderResponseDTO();
                    oDto.setId(order.getOrderId());
                    oDto.setProductName(order.getProductName());
                    oDto.setProductPrice(order.getProductPrice());
                    oDto.setCreatedAt(order.getCreatedAt());
                    oDto.setUpdatedAt(order.getUpdatedAt());
                    return oDto;
                }
        ).toList();

        dto.setOrders(orders);

        return dto;
    }

    // Update users
    public UserUpdateDTO updateUser(Long id, UserUpdateDTO updated) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        LocalDateTime now = LocalDateTime.now();
        if (updated.getName() != null) {
            user.setName(updated.getName());
        }
        if (updated.getEmail() != null) {
            user.setEmail(updated.getEmail());
        }

        user.setUpdatedAt(now);
        UserModel saved = userRepository.save(user);
        return updated;
    }

    // Delete user
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
