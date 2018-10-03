package com.mvp.sample.base

import android.content.Context
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

abstract class BaseActivity : AppCompatActivity(), IBaseView {

    fun setToolbarTitle(textInt: Int) = toolbar?.setTitle(textInt)

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