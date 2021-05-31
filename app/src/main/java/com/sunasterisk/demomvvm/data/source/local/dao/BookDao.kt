package com.sunasterisk.demomvvm.data.source.local.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sunasterisk.demomvvm.data.model.Book

@Dao
interface BookDao {
    @Insert
    fun insertBook(book: Book): Long

    @Query("SELECT * FROM books WHERE idBook = :idBook")
    fun getBook(idBook: String): Book?

    @Query("SELECT * FROM books")
    fun getAllBooks(): List<Book>

    @Delete
    fun deleteBook(book: Book): Int
}
