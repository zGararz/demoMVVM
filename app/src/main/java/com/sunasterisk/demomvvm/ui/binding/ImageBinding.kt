package com.sunasterisk.demomvvm.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sunasterisk.demomvvm.R

@BindingAdapter("android:loadImage")
fun ImageView.loadImage(url: String?) {
    Glide.with(this).load(url).placeholder(R.drawable.book).into(this)
}
