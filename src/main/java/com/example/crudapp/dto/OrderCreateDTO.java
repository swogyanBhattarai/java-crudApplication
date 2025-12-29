package com.example.crudapp.dto;

import jakarta.validation.constraints.*;

public class OrderCreateDTO {
    @NotNull
    @Size(min = 2, max = 20, message = "Product name must be 2-20 characters long.")
    private String productName;

    @NotNull
    @DecimalMin(value = "1.00", message = "Product price must be greater than or equals to 1.00.")
    @Digits(integer = 8, fraction = 2)
    private Double productPrice;

    @NotNull(message = "User id is required.")
    private Long userId;

    // Getters
    public String getProductName() {return productName;}
    public Double getProductPrice() {return productPrice;}
    public Long getUserId() {return userId;}


    // Setters
    public void setProductName(String productName) {this.productName = productName;}
    public void setProductPrice(Double productPrice) {this.productPrice = productPrice;}
    public void setUserId(Long userId) {this.userId = userId;}
}
