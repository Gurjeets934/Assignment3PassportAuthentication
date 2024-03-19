package com.example.assignment3passportauthentication.data

import com.google.gson.annotations.SerializedName

data class LoginDataResponse(
    @SerializedName("email") val email: String,
    @SerializedName("token") val token: String
)
