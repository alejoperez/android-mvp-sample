package com.mvp.sample.login

import com.mvp.sample.base.IBaseView

interface ILoginContract {

    interface View :IBaseView{
        fun onLoginSuccess()
        fun onLoginFailure()
    }

    interface Presenter {
        fun login(email:String, password: String)
    }
}