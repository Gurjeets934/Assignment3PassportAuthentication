package com.example.assignment3passportauthentication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.assignment3passportauthentication.R
import com.example.assignment3passportauthentication.data.LoginData
import com.example.assignment3passportauthentication.data.LoginDataResponse
import com.example.assignment3passportauthentication.preference.PreferenceHandler
import com.example.assignment3passportauthentication.service.APIClientService
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {


    private lateinit var preference: PreferenceHandler
    private lateinit var client: APIClientService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginButton = findViewById<Button>(R.id.button)
        val registerButton = findViewById<Button>(R.id.button2)
        val emailEdittext = findViewById<EditText>(R.id.email)
        val passwordEdittext = findViewById<EditText>(R.id.password)
        client = APIClientService
        preference = PreferenceHandler(this)

        registerButton.setOnClickListener {
            val myIntent = Intent(this, RegisterActivity::class.java)
            startActivity(myIntent)
        }

        loginButton.setOnClickListener {
            val intent = Intent(this, BookListActivity::class.java)
            client.getApiRoute().login(LoginData(email = emailEdittext.text.toString(), password = passwordEdittext.text.toString()))
                .enqueue(object : retrofit2.Callback<LoginDataResponse> {
                    override fun onFailure(call: Call<LoginDataResponse>, t: Throwable) {
                    }
                    override fun onResponse(
                        call: Call<LoginDataResponse>,
                        response: Response<LoginDataResponse>
                    ) {
                        if (response.body()?.email == emailEdittext.text.toString()) {
                            Toast.makeText(this@LoginActivity, "User logged in Successful!", Toast.LENGTH_LONG).show()
                            preference.saveToken(response.body()!!.token)
                            startActivity(intent)
                        }
                    }
                })
        }
    }
}