package com.example.elysium.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.elysium.R
import com.example.elysium.properties.PropertyActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
    }

    private fun init() {
        bttn_properties.setOnClickListener { startActivity(Intent(this, PropertyActivity::class.java)) }
    }
}