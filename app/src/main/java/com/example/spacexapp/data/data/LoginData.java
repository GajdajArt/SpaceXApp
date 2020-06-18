package com.example.spacexapp.data.data;

public class LoginData {

    private String login;

    private String password;

    public LoginData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
