package com.sunasterisk.demomvvm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class Book(
    @PrimaryKey
    @ColumnInfo(name = "idBook")
    val isbn13: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "subtitle")
    val subtitle: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "authors")
    val authors: String,
    @ColumnInfo(name = "publisher")
    val publisher: String,
    @ColumnInfo(name = "language")
    val language: String,
    @ColumnInfo(name = "isbn10")
    val isbn10: String,
    @ColumnInfo(name = "pages")
    val pages: Int,
    @ColumnInfo(name = "year")
    val year: Int,
    @ColumnInfo(name = "rating")
    val rating: Int,
    @ColumnInfo(name = "desc")
    val desc: String
) {
    fun toBookPreview() = BookPreview(isbn13, title, subtitle, image)
}
