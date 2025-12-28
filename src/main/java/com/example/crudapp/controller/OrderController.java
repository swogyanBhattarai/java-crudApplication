package com.example.crudapp.controller;

import com.example.crudapp.model.OrderModel;
import com.example.crudapp.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public OrderModel create(@RequestBody OrderModel order) {
        return orderService.create(order);
    }

    @GetMapping("/getAllOrders")
    public List<OrderModel> getAll() {
        return orderService.getAll();
    }

    @GetMapping("getOrder/{id}")
    public OrderModel getById(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @PutMapping("updateOrder/{id}")
    public OrderModel updateOrder(@PathVariable Long id, @RequestBody OrderModel updated) {
        return orderService.updateOrder(id, updated);
    }

    @DeleteMapping("deleteOrder/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
