package com.example.elysium.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.elysium.Repository.AuthRepository

class AuthViewModel : ViewModel() {

    var name: String? = null
    var email: String? = null
    var password: String? = null
    var authListener: AuthListener? = null
    var type: String? = null

    fun onLoginButtonClicked(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            // fail
            authListener?.onFailure("Login Failed")
            return
        }
        // success
        var loginResponse = AuthRepository().loginuser(email!!, password!!, type!!)
        authListener?.onSuccess(loginResponse)

    }

}