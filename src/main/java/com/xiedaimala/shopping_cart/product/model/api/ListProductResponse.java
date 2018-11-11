package com.xiedaimala.shopping_cart.product.model.api;

import com.xiedaimala.shopping_cart.product.model.Product;

import java.util.List;

public class ListProductResponse {

    private List<Product> products;

    public ListProductResponse() {
    }

    public ListProductResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
