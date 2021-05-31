package com.sunasterisk.demomvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.demomvvm.R
import com.sunasterisk.demomvvm.data.model.BookPreview
import com.sunasterisk.demomvvm.databinding.ItemBookBinding

class BookAdapter(val onBookClick: (BookPreview) -> Unit) :
    ListAdapter<BookPreview, ViewHolder>(BookPreview.diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_book,
            parent,
            false
        ),
        onBookClick
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    fun setData(books: List<BookPreview>) {
        submitList(books)
    }
}

class ViewHolder(
    private val binding: ItemBookBinding,
    private val onBookClick: (BookPreview) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    private var bookItem: BookPreview? = null

    init {
        binding.root.setOnClickListener { bookItem?.let { book -> onBookClick(book) } }
    }

    fun bindData(book: BookPreview) {
        bookItem = book
        binding.book = book
    }
}
