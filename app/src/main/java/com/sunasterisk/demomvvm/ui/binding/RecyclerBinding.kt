package com.sunasterisk.demomvvm.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.demomvvm.data.model.BookPreview
import com.sunasterisk.demomvvm.ui.adapter.BookAdapter

@BindingAdapter("android:data")
fun RecyclerView.setDataRecycler(data: List<BookPreview>?) {
    this.adapter.also {
        if (it is BookAdapter) data?.let { data -> it.setData(data) }
    }
}
