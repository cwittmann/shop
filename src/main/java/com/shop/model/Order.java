package com.shop.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Order {

    @Id
    public String id;
    public String userId;
    public Date date;
    public OrderStatus status;

    public Order(String id, String userId, Date date, OrderStatus status) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.status = status;
    }
}