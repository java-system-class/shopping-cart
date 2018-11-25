package com.xiedaimala.shopping_cart.web.user.view;

public class CreateUserRequest {

    private String username;
    private String password;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        username = "abc;";
        username = username + username;
        username = username + username;
        username = username + username;
        return username;
    }

    public String getUsername2() {
        username = "abc;";
        username = username + username;
        username = username + username;
        username = username + username;
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
