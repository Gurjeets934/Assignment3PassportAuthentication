package com.example.assignment3passportauthentication

import android.R.attr.value
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment3passportauthentication.ui.LoginActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()
        handler.postDelayed({
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
        }, 1000)
    }
}