package com.mvp.sample.login

import com.mvp.sample.R
import com.mvp.sample.data.user.UserRepository
import com.mvp.sample.webservice.LoginRequest
import com.mvp.sample.webservice.LoginResponse


class LoginPresenter(private val view: ILoginContract.View): ILoginContract.Presenter, UserRepository.ILoginListener {

    override fun login(email: String, password: String) = UserRepository.getInstance().login(view.getViewContext(), LoginRequest(email, password),this)

    override fun onLoginSuccess(response: LoginResponse?) {
        if (view.isActive()) {
            view.onLoginSuccess()
        }
    }

    override fun onLoginFailure() {
        if (view.isActive()) {
            view.onLoginFailure()
        }
    }

    override fun onNetworkError() {
        if (view.isActive()) {
            view.showAlert(R.string.error_network)
        }
    }

}