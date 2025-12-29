package com.example.crudapp.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<OrderResponseDTO> orders;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



    // Getters
    public Long getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public List<OrderResponseDTO> getOrders() {return orders;}
    public LocalDateTime getCreatedAt() {return createdAt;}
    public LocalDateTime getUpdatedAt() {return updatedAt;}

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setOrders(List<OrderResponseDTO> orders) { this.orders = orders; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
