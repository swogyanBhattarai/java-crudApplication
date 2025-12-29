package com.example.crudapp.service;

import com.example.crudapp.dto.OrderCreateDTO;
import com.example.crudapp.dto.OrderResponseDTO;
import com.example.crudapp.model.OrderModel;
import com.example.crudapp.model.UserModel;
import com.example.crudapp.repository.OrderRepository;
import com.example.crudapp.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    // Create order
    public OrderModel create (@Valid OrderCreateDTO orderDto) {
        OrderModel order = new OrderModel();
        UserModel user = userRepository.findById(orderDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        order.setProductName(orderDto.getProductName());
        order.setProductPrice(orderDto.getProductPrice());
        order.setUser(user);

        LocalDateTime now = LocalDateTime.now();
        order.setCreatedAt(now);
        order.setUpdatedAt(now);

        return orderRepository.save(order);
    }

    // Get all orders
    public List<OrderModel> getAll() {
        return orderRepository.findAll();
    }

    // Get order by id
    public OrderResponseDTO getById(Long id) {
        OrderModel order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        OrderResponseDTO mapped = new OrderResponseDTO();
        mapped.setId(order.getOrderId());
        mapped.setProductName(order.getProductName());
        mapped.setProductPrice(order.getProductPrice());
        mapped.setCreatedAt(order.getCreatedAt());
        mapped.setUpdatedAt(order.getUpdatedAt());
        mapped.setUserId(order.getUser().getId());
        return mapped;
    }

    // Update order
    public OrderModel updateOrder (Long orderId, @Valid OrderResponseDTO updated) {
        OrderModel order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        LocalDateTime now = LocalDateTime.now();
        if (updated.getProductName() != null) {
            order.setProductName(updated.getProductName());
        }
        if (updated.getProductPrice() != null) {
            order.setProductPrice(updated.getProductPrice());
        }
        order.setUpdatedAt(now);
        return orderRepository.save(order);
    }

    // Delete order by id
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
