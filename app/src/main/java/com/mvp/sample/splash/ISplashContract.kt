package com.mvp.sample.splash

interface ISplashContract {

    interface View {
        fun goToNextScreen()
    }

    interface Presenter {
        fun isLoggedIn(): Boolean
    }

}