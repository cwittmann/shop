package com.shop.model;

import org.springframework.data.annotation.Id;

public class Image {
    @Id
    public String id;
    public byte[] data;

    public Image(String id, byte[] data) {
        this.id = id;
        this.data = data;
    }
}