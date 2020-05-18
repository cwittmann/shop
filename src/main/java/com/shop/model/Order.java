package com.shop.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Order {
    @Id
    public String id;
    public String userId;
    public Date date;
    public OrderStatus status;
    public OrderLine[] orderLines;

    public Order() {
    }

    public Order(String id, String userId, Date date, OrderStatus status, OrderLine[] orderLines) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.status = status;
        this.orderLines = orderLines;
    }
}