package com.example.crudapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<OrderModel> orders;

    // getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public List<OrderModel> getOrders() {
        return orders;
    }

    // setters
    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}
    public void setOrders(List<OrderModel> orders) {this.orders = orders;}
}
