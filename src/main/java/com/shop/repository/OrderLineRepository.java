package com.shop.repository;

import java.util.List;

import com.shop.model.OrderLine;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderLineRepository extends MongoRepository<OrderLine, String> {

    public List<OrderLine> findByOrderId(String orderId);
}