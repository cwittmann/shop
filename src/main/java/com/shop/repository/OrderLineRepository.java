package com.shop.repository;

import com.shop.model.OrderLine;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderLineRepository extends MongoRepository<OrderLine, String> {

}