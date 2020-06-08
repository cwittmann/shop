package com.shop.model;

import org.springframework.data.annotation.Id;

public class Category {
    @Id
    public String id;
    public String name;

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

}