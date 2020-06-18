package com.example.spacexapp

import android.util.Log
import com.example.spacexapp.data.Callback
import com.example.spacexapp.data.data.LoginData
import com.example.spacexapp.data.data.LoginResultData
import com.example.spacexapp.domain.LoginInteractor
import com.example.spacexapp.domain.impl.LoginInteractorImpl
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val loginInteractor: LoginInteractor = LoginInteractorImpl()

        loginInteractor.login(LoginData("Admin", "12345"), object : Callback<LoginResultData> {
            override fun onSuccess(result: LoginResultData) {
                println("### ${result.name}")
            }

            override fun onError(errorMessage: String) {
                println("### error $errorMessage")
            }

        })
    }
}