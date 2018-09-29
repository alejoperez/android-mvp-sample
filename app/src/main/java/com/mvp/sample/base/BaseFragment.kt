package com.mvp.sample.base

import android.support.v4.app.Fragment

abstract class BaseFragment: Fragment(), IBaseView {

    override fun isActive(): Boolean = isAdded

}