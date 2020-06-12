package com.shop.model;

import org.springframework.data.annotation.Id;

public class Attribute {
    @Id
    public String id;
    public String name;
    public String value;

    public Attribute(String id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
}