package com.example.spacexapp.data.model;

public class LoginResultData {

    private String token;

    private String name;

    public LoginResultData(String token, String name) {
        this.token = token;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }
}
