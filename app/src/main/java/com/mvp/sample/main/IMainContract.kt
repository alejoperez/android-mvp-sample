package com.mvp.sample.main

import com.mvp.sample.base.IBaseView

interface IMainContract {

    interface View: IBaseView

    interface Presenter {
        fun logout()
    }

}