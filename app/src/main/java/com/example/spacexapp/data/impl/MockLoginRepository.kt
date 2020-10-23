package com.example.spacexapp.data.impl

import android.os.Handler
import com.example.spacexapp.data.Callback
import com.example.spacexapp.data.model.LoginData
import com.example.spacexapp.data.model.LoginResultData
import com.example.spacexapp.domain.repository.LoginRepository
import com.example.spacexapp.domain.repository.LoginRepository.OOPS_ERROR_MESSAGE
import com.example.spacexapp.domain.repository.LoginRepository.WRONG_PASSWORD_ERROR_MESSAGE

class MockLoginRepository: LoginRepository {

    private var callback: Callback<LoginResultData>? = null
    private var loginData: LoginData? = null

    //Реализация Runnable которая будет выполнена после паузы
    private val loginRunnable = object : Runnable {

        override fun run() {
            //Имитируем ошибку
            if (isError) {
                callback?.onError(OOPS_ERROR_MESSAGE)
                return
            }

            //Проверяем правельность логина и пароля и отдаем результат
            if (loginData?.login == LoginRepository.LOGIN && loginData?.password == LoginRepository.PASSWORD) {
                callback?.onSuccess(LoginResultData(LoginRepository.TOKEN, LoginRepository.NAME))
            } else {
                callback?.onError(WRONG_PASSWORD_ERROR_MESSAGE)
            }
        }

        private val isError = Math.random() < 0.2
    }

    override fun login(loginData: LoginData?, callback: Callback<LoginResultData>?) {
        this.loginData = loginData
        this.callback = callback

        //запускаем loginRunnable с задержкой
        Handler().postDelayed(loginRunnable, MOCK_DELAY)
    }

    companion object {
        private const val MOCK_DELAY = 2000L
    }
}