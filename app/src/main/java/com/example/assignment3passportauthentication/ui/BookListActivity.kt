package com.example.assignment3passportauthentication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment3passportauthentication.R
import com.example.assignment3passportauthentication.data.BookData
import com.example.assignment3passportauthentication.data.BookListResponse
import com.example.assignment3passportauthentication.preference.PreferenceHandler
import com.example.assignment3passportauthentication.service.APIClientService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookListActivity : AppCompatActivity() {

    private lateinit var preference: PreferenceHandler
    private lateinit var apiClientService: APIClientService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        apiClientService = APIClientService
        preference = PreferenceHandler(this)
        fetchBookList()
    }

    private fun fetchBookList() {
        val token = preference.getToken().toString()
        apiClientService.getApiRoute()
            .getBookList(token = "Bearer $token")
            .enqueue(object : Callback<List<BookListResponse>> {
                override fun onFailure(call: Call<List<BookListResponse>>, t: Throwable) {
                }
                override fun onResponse(
                    call: Call<List<BookListResponse>>,
                    response: Response<List<BookListResponse>>
                ) {
                    val recyclerViewBook = findViewById<RecyclerView>(R.id.recyclerView)
                    recyclerViewBook.layoutManager = LinearLayoutManager(this@BookListActivity)
                    recyclerViewBook.adapter = BookListAdapter(response.body())
                }
            })
    }
}