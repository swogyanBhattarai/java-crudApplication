package com.example.crudapp.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Double productPrice;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserModel user;

    //getters
    public Long getOrderId() {return orderId;}
    public String getProductName() {return productName;}
    public Double getProductPrice() {return productPrice;}

    //setters
    public void setProductName(String productName) {this.productName = productName;}
    public void setProductPrice(Double productPrice) {this.productPrice = productPrice;}
}
