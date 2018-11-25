package com.xiedaimala.shopping_cart.web.order.view;

public class UpdateOrderRequest {

    private long quantity;
    private String status;
    private String address;

    public UpdateOrderRequest() {
    }

    public UpdateOrderRequest(long quantity, String status, String address) {
        this.quantity = quantity;
        this.status = status;
        this.address = address;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
