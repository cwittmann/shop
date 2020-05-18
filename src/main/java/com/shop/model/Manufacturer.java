package com.shop.model;

import org.springframework.data.annotation.Id;

public class Manufacturer {
    @Id
    public String id;
    public String name;

    public Manufacturer() {
    }

    public Manufacturer(String id, String name) {
        this.id = id;
        this.name = name;
    }
}