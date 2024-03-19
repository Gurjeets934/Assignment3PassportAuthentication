package com.example.assignment3passportauthentication.service

import com.example.assignment3passportauthentication.data.BookListResponse
import com.example.assignment3passportauthentication.data.LoginData
import com.example.assignment3passportauthentication.data.LoginDataResponse
import com.example.assignment3passportauthentication.data.RegisterData
import com.example.assignment3passportauthentication.data.RegisterDataResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface APIRouteService {

    @POST("login")
    fun login(@Body request: LoginData): Call<LoginDataResponse>


    @POST("register")
    fun register(@Body request: RegisterData): Call<RegisterDataResponse>

    @GET("books")
    fun getBookList(@Header("Authorization") token: String): Call<List<BookListResponse>>

}