package com.shop.repository;

import com.shop.model.Right;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RightRepository extends MongoRepository<Right, String> {

}