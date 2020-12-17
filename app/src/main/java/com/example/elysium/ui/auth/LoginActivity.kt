package com.example.elysium.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.elysium.R
import com.example.elysium.databinding.ActivityLoginBinding
import com.example.elysium.helpers.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    lateinit var sessionManager: SessionManager

    lateinit var mBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_login)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        var authViewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        mBinding.viewmodel = authViewModel
        authViewModel.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()
        this.d("started.....")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        progress_bar.hide()
        loginResponse.observe(this, Observer {
            this.toast("Success")
            this.d("success...")
        })
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        this.toast("failed")
        this.d("failure...")
    }
}