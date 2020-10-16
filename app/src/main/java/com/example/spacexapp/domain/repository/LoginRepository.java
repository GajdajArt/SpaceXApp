package com.example.spacexapp.domain.repository;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.data.model.LoginData;
import com.example.spacexapp.data.model.LoginResultData;

public interface LoginRepository {

    void login(LoginData loginData, Callback<LoginResultData> callback);
}
