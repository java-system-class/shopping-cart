package com.xiedaimala.shopping_cart.cart.controller.model;

import com.xiedaimala.shopping_cart.cart.model.CartItem;

public class GetCartItemResponse {

    private CartItem item;

    public GetCartItemResponse(CartItem item) {
        this.item = item;
    }

    public CartItem getItem() {
        return item;
    }

    public void setItem(CartItem item) {
        this.item = item;
    }
}
