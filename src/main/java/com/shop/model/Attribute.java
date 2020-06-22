package com.shop.model;

import org.springframework.data.annotation.Id;

public class Attribute {
    @Id
    public String id;
    public String productId;
    public String name;
    public String value;
    public String info;

    public Attribute(String id, String productId, String name, String value, String info) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.value = value;
        this.info = info;
    }
}