package com.example.spacexapp.domain.interactor;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.data.impl.MockLoginRepository;
import com.example.spacexapp.domain.repository.LoginRepository;
import com.example.spacexapp.data.model.LoginData;
import com.example.spacexapp.data.model.LoginResultData;
import com.example.spacexapp.data.impl.MockAsyncLoginRepository;

public class LoginInteractor {

    private LoginRepository loginRepository;

    public LoginInteractor() {
        loginRepository = new MockLoginRepository();
    }

    public void login(LoginData loginData, Callback<LoginResultData> callback) {
        loginRepository.login(loginData, callback);
    }
}
