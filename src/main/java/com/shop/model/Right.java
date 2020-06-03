package com.shop.model;

import org.springframework.data.annotation.Id;

public class Right {

    @Id
    public String id;
    public String entity;
    public String permission;

    public Right(String id, String entity, String permission) {
        this.id = id;
        this.entity = entity;
        this.permission = permission;
    }
}