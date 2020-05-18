package com.shop.model;

import org.springframework.data.annotation.Id;

public class OrderLine {

    @Id
    public String id;
    public String orderId;
    public String productId;
    public Integer amount;

    public OrderLine() {
    }

    public OrderLine(String id, String orderId, String productId, Integer amount) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
    }
}