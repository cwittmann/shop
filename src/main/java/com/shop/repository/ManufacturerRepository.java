package com.shop.repository;

import com.shop.model.Manufacturer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ManufacturerRepository extends MongoRepository<Manufacturer, String> {

}