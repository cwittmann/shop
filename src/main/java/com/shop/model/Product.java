package com.shop.model;

import org.springframework.data.annotation.Id;

public class Product {
    @Id
    public String id;
    public String name;
    public String description;
    public String price;
    public String categoryId;
    public Category category;
    public String manufacturerId;
    public Manufacturer manufacturer;

    public Product(String id, String name, String description, String price, String categoryId, Category category,
            String manufacturerId, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.category = category;
        this.manufacturerId = manufacturerId;
        this.manufacturer = manufacturer;
    }
}