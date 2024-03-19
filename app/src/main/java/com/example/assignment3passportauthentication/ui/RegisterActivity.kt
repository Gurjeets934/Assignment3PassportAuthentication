package com.example.assignment3passportauthentication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.assignment3passportauthentication.R
import com.example.assignment3passportauthentication.preference.PreferenceHandler
import com.example.assignment3passportauthentication.service.APIClientService

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerButton = findViewById<Button>(R.id.button)
        val loginButton = findViewById<Button>(R.id.button2)

        registerButton.setOnClickListener {
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
        }

        loginButton.setOnClickListener {
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
        }
    }
}