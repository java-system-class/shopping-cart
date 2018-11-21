package com.xiedaimala.shopping_cart.cart.controller.model;

import com.xiedaimala.shopping_cart.cart.model.CartItem;

public class UpdateCartItemResponse {

    private CartItem item;

    public UpdateCartItemResponse() {
    }

    public UpdateCartItemResponse(CartItem item) {
        this.item = item;
    }

    public CartItem getItem() {
        return item;
    }

    public void setItem(CartItem item) {
        this.item = item;
    }
}
