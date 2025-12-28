package com.example.crudapp.service;

import com.example.crudapp.model.OrderModel;
import com.example.crudapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Create order
    public OrderModel create (OrderModel order) {
        return orderRepository.save(order);
    }

    // Get all orders
    public List<OrderModel> getAll() {
        return orderRepository.findAll();
    }

    // Get order by id
    public OrderModel getById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // Update order
    public OrderModel updateOrder (Long orderId, OrderModel updated) {
        OrderModel order = getById(orderId);
        order.setProductName(updated.getProductName());
        order.setProductPrice(updated.getProductPrice());
        return orderRepository.save(order);
    }

    // Delete order by id
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
