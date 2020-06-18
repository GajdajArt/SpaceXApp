package com.example.spacexapp.data;

import com.example.spacexapp.data.data.LoginData;
import com.example.spacexapp.data.data.LoginResultData;

public interface LoginRepository {

    void login(LoginData loginData, Callback<LoginResultData> callback);
}
