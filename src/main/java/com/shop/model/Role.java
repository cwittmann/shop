package com.shop.model;

import org.springframework.data.annotation.Id;

public class Role {
    @Id
    public String id;
    public String name;
    public Right[] rights;

    public Role(String id, String name, Right[] rights) {
        this.id = id;
        this.name = name;
        this.rights = rights;
    }
}