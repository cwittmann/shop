package com.shop.model;

import org.springframework.data.annotation.Id;

public class OrderLine {

    @Id
    public String id;
    public String orderId;
    public Integer amount;
    public String productId;
    public Product product;

    public OrderLine(String id, String orderId, Integer amount, String productId, Product product) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.productId = productId;
        this.product = product;
    }
}