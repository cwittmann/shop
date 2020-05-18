package com.shop.controller;

import java.util.List;

import com.shop.model.Order;
import com.shop.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/orders")
    public List<Order> getOrders() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable String id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Order not found: " + id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/orders")
    public Order postOrder(@RequestBody Order order) {
        return repository.insert(order);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/orders/{id}")
    public Order putOrder(@RequestBody Order newOrder, @PathVariable String id) throws Exception {
        return repository.findById(id).map(order -> {
            order = newOrder;
            return repository.save(order);
        }).orElseThrow(() -> new Exception("Order not found: " + id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable String id) {
        repository.deleteById(id);
    }

}