package com.mvp.sample.data.user

import android.content.Context
import com.mvp.sample.data.User
import com.mvp.sample.extensions.enqueue
import com.mvp.sample.webservice.IApi
import com.mvp.sample.webservice.LoginRequest
import com.mvp.sample.webservice.RegisterRequest
import com.mvp.sample.webservice.WebService

class UserRemoteDataSource : IUserDataSource {

    override fun login(context: Context, request: LoginRequest, listener: UserRepository.ILoginListener) {
        val service = WebService.createService(context, IApi::class.java)
        val call = service.login(request)
        call.enqueue(
                { response ->
                    if (response.isSuccessful) {
                        listener.onLoginSuccess(response.body())
                    } else {
                        listener.onLoginFailure()
                    }
                },
                {
                    listener.onNetworkError()
                }
        )
    }

    override fun register(context: Context, request: RegisterRequest, listener: UserRepository.IRegisterListener) {
        val service = WebService.createService(context, IApi::class.java)
        val call = service.register(request)
        call.enqueue(
                { response ->
                    if (response.isSuccessful) {
                        listener.onRegisterSuccess(response.body())
                    } else {
                        listener.onRegisterFailure()
                    }
                },
                {
                    listener.onNetworkError()
                }
        )
    }

    override fun logout(context: Context) = throw UnsupportedOperationException()

    override fun getUser(): User? = throw UnsupportedOperationException()

    override fun saveUser(user: User) = throw UnsupportedOperationException()

    override fun isLoggedIn(context: Context): Boolean = throw UnsupportedOperationException()
}