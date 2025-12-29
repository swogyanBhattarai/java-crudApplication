package com.example.crudapp.dto;

import java.time.LocalDateTime;

public class OrderResponseDTO {
    private Long id;
    private String productName;
    private Double productPrice;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters
    public Long getId() {return id;}
    public String getProductName() {return productName;}
    public Double getProductPrice() {return productPrice;}
    public Long getUserId() {return userId;}
    public LocalDateTime getCreatedAt() {return createdAt;}
    public LocalDateTime getUpdatedAt() {return updatedAt;}

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setProductPrice(Double productPrice) {this.productPrice = productPrice;}
    public void setUserId(Long userId) {this.userId = userId;}
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
