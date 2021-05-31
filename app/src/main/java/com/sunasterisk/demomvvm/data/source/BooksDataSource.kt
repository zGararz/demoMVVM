package com.sunasterisk.demomvvm.data.source

import com.sunasterisk.demomvvm.data.model.Book
import com.sunasterisk.demomvvm.data.model.BooksResponse

interface BooksDataSource {
    interface Remote {
        suspend fun getNewsBook(): BooksResponse
        suspend fun getRemoteBook(id: String): Book
    }

    interface Local {
        suspend fun insertBook(book: Book): Long
        suspend fun getBook(id: String): Book?
        suspend fun getAllBooks(): List<Book>?
        suspend fun deleteBook(book: Book): Int
    }
}
