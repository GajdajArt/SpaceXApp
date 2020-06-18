package com.example.spacexapp.domain.impl;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.data.LoginRepository;
import com.example.spacexapp.data.data.LoginData;
import com.example.spacexapp.data.data.LoginResultData;
import com.example.spacexapp.data.impl.MockLoginRepository;
import com.example.spacexapp.domain.LoginInteractor;

public class LoginInteractorImpl implements LoginInteractor {

    private LoginRepository loginRepository;

    public LoginInteractorImpl() {
        loginRepository = new MockLoginRepository();
    }

    @Override
    public void login(LoginData loginData, Callback<LoginResultData> callback) {
        loginRepository.login(loginData, callback);
    }
}
