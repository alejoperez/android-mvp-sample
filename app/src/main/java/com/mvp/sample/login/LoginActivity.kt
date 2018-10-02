package com.mvp.sample.login

import android.os.Bundle
import android.view.View
import com.mvp.sample.R
import com.mvp.sample.base.BaseActivity
import com.mvp.sample.extensions.getWhiteSpaceFilters
import com.mvp.sample.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : BaseActivity(), ILoginContract.View {

    private val presenter: LoginPresenter by lazy { LoginPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setToolbarTitle(R.string.login_title)

        etEmail.filters = getWhiteSpaceFilters()
        etPassword.filters = getWhiteSpaceFilters()

        btLogin.setOnClickListener {
            onLoginClicked()
        }

    }

    private fun onLoginClicked() {
        if (presenter.isValidForm(getEmail(), getPassword())) {
            presenter.login(getEmail(), getPassword())
        } else {
            if (!presenter.isValidEmail(getEmail())) {
                etEmail.error = getString(R.string.error_invalid_email)
            }
            if (!presenter.isValidPassword(getPassword())) {
                etPassword.error = getString(R.string.error_empty_password)
            }
        }
    }

    override fun getEmail(): String = etEmail.text.toString()

    override fun getPassword(): String = etPassword.text.toString()

    override fun onLoginSuccess() {
        startActivity<MainActivity>()
        finish()
    }

    override fun onLoginFailure() = showAlert(R.string.error_invalid_credentials)

    override fun showProgress() {
        btLogin.visibility = View.INVISIBLE
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        btLogin.visibility = View.VISIBLE
        progress.visibility = View.INVISIBLE
    }
}
