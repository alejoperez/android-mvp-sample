package com.mvp.sample.main

import com.mvp.sample.base.IBaseView
import com.mvp.sample.data.User

interface IMainContract {

    interface View: IBaseView

    interface Presenter {
        fun getUser(): User?
        fun logout()
    }

}