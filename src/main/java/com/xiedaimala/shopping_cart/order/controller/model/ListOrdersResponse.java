package com.xiedaimala.shopping_cart.order.controller.model;

import com.xiedaimala.shopping_cart.order.model.Order;

import java.util.List;

public class ListOrdersResponse {

    List<Order> orders;

    public ListOrdersResponse() {
    }

    public ListOrdersResponse(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
