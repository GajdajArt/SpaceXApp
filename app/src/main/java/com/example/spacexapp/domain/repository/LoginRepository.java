package com.example.spacexapp.domain.repository;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.data.model.LoginData;
import com.example.spacexapp.data.model.LoginResultData;

public interface LoginRepository {

    String LOGIN = "admin@gmail.com";
    String PASSWORD = "12345";
    String TOKEN = "123456";
    String NAME = "Bob";

    String WRONG_PASSWORD_ERROR_MESSAGE = "Wrong login or password";
    String OOPS_ERROR_MESSAGE = "Oops, looser =P";

    void login(LoginData loginData, Callback<LoginResultData> callback);
}
