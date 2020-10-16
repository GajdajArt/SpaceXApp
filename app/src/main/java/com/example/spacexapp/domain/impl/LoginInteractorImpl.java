package com.example.spacexapp.domain.impl;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.domain.repository.LoginRepository;
import com.example.spacexapp.data.model.LoginData;
import com.example.spacexapp.data.model.LoginResultData;
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
