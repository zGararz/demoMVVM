package com.sunasterisk.demomvvm.data.repository

import com.sunasterisk.demomvvm.data.model.Book
import com.sunasterisk.demomvvm.data.model.BooksResponse
import com.sunasterisk.demomvvm.data.source.BooksDataSource

interface BooksRepository {
    suspend fun getNewsBook(): BooksResponse
    suspend fun getRemoteBook(id: String): Book

    suspend fun insertBook(book: Book): Long
    suspend fun getBook(id: String): Book?
    suspend fun getAllBooks(): List<Book>?
    suspend fun deleteBook(book: Book): Int
}
