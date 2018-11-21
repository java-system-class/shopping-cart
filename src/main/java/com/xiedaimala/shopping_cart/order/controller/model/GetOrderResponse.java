package com.xiedaimala.shopping_cart.order.controller.model;

import com.xiedaimala.shopping_cart.order.model.Order;

public class GetOrderResponse {

    Order order;

    public GetOrderResponse() {
    }

    public GetOrderResponse(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
