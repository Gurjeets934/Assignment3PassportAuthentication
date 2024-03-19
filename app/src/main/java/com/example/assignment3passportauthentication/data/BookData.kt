package com.example.assignment3passportauthentication.data

import com.google.gson.annotations.SerializedName

data class BookData(
    @SerializedName("title")
    val title: String?,

    @SerializedName("author")
    val author: String?,

    @SerializedName("rating")
    val rating: Int,
)