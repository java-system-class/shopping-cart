package com.xiedaimala.shopping_cart.web.user.view;

public class CreateUserResponse {

    UserView user;

    public CreateUserResponse() {
    }

    public CreateUserResponse(UserView user) {
        this.user = user;
    }

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
    }
}
