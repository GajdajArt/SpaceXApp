package com.example.spacexapp.domain;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.data.model.LoginData;
import com.example.spacexapp.data.model.LoginResultData;

public interface LoginInteractor {

    void login(LoginData loginData, Callback<LoginResultData> callback);
}
