package com.shop.model;

import org.springframework.data.annotation.Id;

public class Role {
    @Id
    public String id;
    public String name;

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }
}