package com.example.spacexapp

import com.example.spacexapp.data.Callback
import com.example.spacexapp.data.model.LoginData
import com.example.spacexapp.data.model.LoginResultData
import com.example.spacexapp.domain.interactor.LoginInteractor
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val loginInteractor: LoginInteractor =
            LoginInteractor()

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