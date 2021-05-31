package com.sunasterisk.demomvvm.data.model

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookPreview(
    val isbn13: String,
    val title: String,
    val subtitle: String,
    val image: String
) : Parcelable {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<BookPreview>() {
            override fun areItemsTheSame(oldItem: BookPreview, newItem: BookPreview): Boolean {
                return oldItem.isbn13 == newItem.isbn13
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: BookPreview, newItem: BookPreview): Boolean {
                return oldItem == newItem
            }
        }
    }
}
