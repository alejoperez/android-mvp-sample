package com.mvp.sample.base

import android.support.v7.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity(), IBaseView {

    override fun isActive(): Boolean = !isFinishing


}