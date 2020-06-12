package com.shop.model;

import org.springframework.data.annotation.Id;

public class Attribute {
    @Id
    public String id;
    public String productId;
    public String name;
    public String value;

    public Attribute(String id, String productId, String name, String value) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.value = value;
    }
}