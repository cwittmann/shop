package com.shop.controller;

import java.util.List;

import com.shop.exception.NotFoundException;
import com.shop.model.OrderLine;
import com.shop.repository.OrderLineRepository;

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
@CrossOrigin(origins = "http://localhost:4200")
public class OrderLineController {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @GetMapping("/orderLines")
    public List<OrderLine> getOrderLines() {
        return orderLineRepository.findAll();
    }

    @GetMapping("/orderLines/{id}")
    public OrderLine getOrderLine(@PathVariable String id) {
        return orderLineRepository.findById(id).orElseThrow(() -> new NotFoundException("OrderLine not found: " + id));
    }

    @PostMapping("/orderLines")
    public OrderLine postOrderLine(@RequestBody OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    @PutMapping("/orderLines/{id}")
    public OrderLine putOrderLine(@RequestBody OrderLine newOrderLine, @PathVariable String id) {
        return orderLineRepository.findById(id).map(orderLine -> {
            return orderLineRepository.save(newOrderLine);
        }).orElseThrow(() -> new NotFoundException("OrderLine not found: " + id));
    }

    @DeleteMapping("/orderLines/{id}")
    public void deleteOrderLine(@PathVariable String id) {
        orderLineRepository.deleteById(id);
    }
}