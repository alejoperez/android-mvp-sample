package com.mvp.sample.base

import android.content.Context
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

abstract class BaseActivity : AppCompatActivity(), IBaseView {

    override fun isActive(): Boolean = !isFinishing

    override fun showAlert(textResource: Int) {
        if (isActive()) {
            alert(textResource) {
                yesButton { dialog -> dialog.dismiss() }
            }.show()
        }
    }

    override fun getViewContext(): Context = this

}