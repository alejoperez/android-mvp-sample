package com.mvp.sample.login

import android.os.Bundle
import com.mvp.sample.R
import com.mvp.sample.base.BaseActivity
import com.mvp.sample.main.MainActivity
import org.jetbrains.anko.startActivity

class LoginActivity : BaseActivity(), ILoginContract.View {

    private val presenter: LoginPresenter by lazy { LoginPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onLoginSuccess() {
        startActivity<MainActivity>()
        finish()
    }

    override fun onLoginFailure() = showAlert(R.string.error_invalid_credentials)
}
