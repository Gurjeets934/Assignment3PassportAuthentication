package com.example.assignment3passportauthentication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment3passportauthentication.data.BookListResponse
import com.example.assignment3passportauthentication.databinding.BookRowBinding

class BookListAdapter(private var books: List<BookListResponse>?) : RecyclerView.Adapter<BookListAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: BookRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BookListResponse?) {
            binding.title.text = item?.title
            binding.author.text = item?.author
            binding.rating.text = item?.rating.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = MyViewHolder(BookRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        return view
    }

    override fun getItemCount(): Int = books?.size!!

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        return holder.bind(books?.get(position))
    }
}