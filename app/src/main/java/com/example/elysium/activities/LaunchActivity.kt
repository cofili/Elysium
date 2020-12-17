package com.example.elysium.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.elysium.ui.MainActivity
import com.example.elysium.R
import com.example.elysium.helpers.SessionManager
import com.example.elysium.ui.auth.LoginActivity

class LaunchActivity : AppCompatActivity() {

    lateinit var sessionManager: SessionManager

    private val delayedTime: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        var handler = Handler()
        handler.postDelayed({

            checkLogin()

        }, delayedTime )

    }

    private fun checkLogin() {
        sessionManager = SessionManager(this)
        var intent = if(sessionManager.isLoggedIn()){
            //user is logged in
            Intent(this, MainActivity::class.java)
        }else{
            //user not logged in send to login activity
            Intent(this, LoginActivity::class.java)
        }

        startActivity(intent)
        finish()

    }
}