package com.shop.repository;

import com.shop.model.Attribute;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttributeRepository extends MongoRepository<Attribute, String> {

}