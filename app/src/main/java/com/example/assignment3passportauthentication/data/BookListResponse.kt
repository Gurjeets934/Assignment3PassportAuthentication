package com.example.assignment3passportauthentication.data

import com.google.gson.annotations.SerializedName

data class BookListResponse(
    @SerializedName("BooksName") val title: String?,
    @SerializedName("Author") val author: String?,
    @SerializedName("Rating") val rating: Double,
)