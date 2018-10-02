package com.mvp.sample.splash

import com.mvp.sample.base.IBaseView

interface ISplashContract {

    interface View: IBaseView {
        fun goToNextScreen()
    }

    interface Presenter {
        fun isLoggedIn(): Boolean
    }

}