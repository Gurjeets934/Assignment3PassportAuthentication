package com.example.assignment3passportauthentication.data

import com.google.gson.annotations.SerializedName

data class RegisterData(
    @SerializedName("firstName") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)

