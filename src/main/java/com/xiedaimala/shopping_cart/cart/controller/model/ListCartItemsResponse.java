package com.xiedaimala.shopping_cart.cart.controller.model;

import com.xiedaimala.shopping_cart.cart.model.CartItem;

import java.util.List;

public class ListCartItemsResponse {

    private List<CartItem> items;

    public ListCartItemsResponse(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
}
