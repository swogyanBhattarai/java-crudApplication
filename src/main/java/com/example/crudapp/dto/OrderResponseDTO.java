package com.example.crudapp.dto;

import java.time.LocalDateTime;

public class OrderResponseDTO {
    private Long id;
    private String productName;
    private Double productPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserResponseDTO user;

    // Getters
    public Long getId() {return id;}
    public String getProductName() {return productName;}
    public Double getProductPrice() {return productPrice;}
    public LocalDateTime getCreatedAt() {return createdAt;}
    public LocalDateTime getUpdatedAt() {return updatedAt;}
    public UserResponseDTO getUser() {return user;}

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setProductName(String productName) { this.productName = this.productName; }
    public void setProductPrice(Double productPrice) {this.productPrice = productPrice;}
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public void setUser(UserResponseDTO user) { this.user = user;}
}
