package com.example.spacexapp.data.impl;

import android.util.Log;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.data.LoginRepository;
import com.example.spacexapp.data.data.LoginData;
import com.example.spacexapp.data.data.LoginResultData;

public class MockLoginRepository implements LoginRepository {

    private static final String LOGIN = "Admin";
    private static final String PASSWORD = "12345";
    private static final String TOKEN = "123456";
    private static final String NAME = "Bob";

    private Callback<LoginResultData> callback;
    private Thread backgroundThread;
    private LoginData loginData;

    @Override
    public void login(LoginData loginData, Callback<LoginResultData> callback) {
        //Сохраняем колбек для дальнейшего его использования
        this.callback = callback;
        //Сохраняем loginData для дальнейшего его использования
        this.loginData = loginData;

        //создаем новый поток
        backgroundThread = new Thread(new LoginRunnable());
        //запускаем новй поток
        backgroundThread.start();
    }

    //Реализация Runnable которая будет выполнена в паралельном потоке
    private class LoginRunnable implements Runnable {

        @Override
        public void run() {
            //Иметируем задерку на 2 секунды призагрузке данных
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Имитируем ошибку
            if (isError()) {
                callback.onError("Oops, looser =P");
                return;
            }

            //Проверяем правельность логина и пароля и отдаем результат
            if (loginData.getLogin().equals(LOGIN) && loginData.getPassword().equals(PASSWORD)) {
                callback.onSuccess(new LoginResultData(TOKEN, NAME));
            } else  {
                callback.onError("Wrong login or password");
            }
        }

        private boolean isError() {
            return Math.random() < 0.2;
        }
    }
}
