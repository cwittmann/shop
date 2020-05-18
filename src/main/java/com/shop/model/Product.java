package com.shop.model;

import org.springframework.data.annotation.Id;

public class Product {

    @Id
    public String id;
    public String manufacturerId;
    public String name;
    public String description;
    public String price;

    public Product() {
    }

    public Product(String id, String manufacturerId, String name, String description, String price) {
        this.id = id;
        this.manufacturerId = manufacturerId;
        this.name = name;
        this.description = description;
        this.price = price;
    }
}