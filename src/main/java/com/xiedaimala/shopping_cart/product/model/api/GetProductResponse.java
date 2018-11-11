package com.xiedaimala.shopping_cart.product.model.api;

import com.xiedaimala.shopping_cart.product.model.Product;

public class GetProductResponse {

    private Product product;

    public GetProductResponse(Product product) {
        this.product = product;
    }

    public GetProductResponse() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
