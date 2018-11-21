package com.xiedaimala.shopping_cart.cart.controller.model;

import com.xiedaimala.shopping_cart.cart.model.CartItem;

public class CreateCartItemResponse {

    CartItem item;

    public CreateCartItemResponse() {
    }

    public CreateCartItemResponse(CartItem item) {
        this.item = item;
    }

    public CartItem getItem() {
        return item;
    }

    public void setItem(CartItem item) {
        this.item = item;
    }
}
