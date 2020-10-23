package com.example.spacexapp.data.impl;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.domain.repository.LoginRepository;
import com.example.spacexapp.data.model.LoginData;
import com.example.spacexapp.data.model.LoginResultData;

public class MockAsyncLoginRepository implements LoginRepository {

    private static final Long MOCK_DELAY = 2000L;

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
                Thread.sleep(MOCK_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Имитируем ошибку
            if (isError()) {
                callback.onError(OOPS_ERROR_MESSAGE);
                return;
            }

            //Проверяем правельность логина и пароля и отдаем результат
            if (loginData.getLogin().equals(LOGIN) && loginData.getPassword().equals(PASSWORD)) {
                callback.onSuccess(new LoginResultData(TOKEN, NAME));
            } else  {
                callback.onError(WRONG_PASSWORD_ERROR_MESSAGE);
            }
        }

        private boolean isError() {
            return Math.random() < 0.2;
        }
    }
}
