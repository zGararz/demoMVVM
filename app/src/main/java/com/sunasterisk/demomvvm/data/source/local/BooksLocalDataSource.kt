package com.sunasterisk.demomvvm.data.source.local

import com.sunasterisk.demomvvm.data.model.Book
import com.sunasterisk.demomvvm.data.source.BooksDataSource
import com.sunasterisk.demomvvm.data.source.local.dao.BookDao

class BooksLocalDataSource(
    private val bookDao: BookDao
) : BooksDataSource.Local {

    override suspend fun insertBook(book: Book) = bookDao.insertBook(book)
    override suspend fun getBook(id: String) = bookDao.getBook(id)
    override suspend fun getAllBooks() = bookDao.getAllBooks()
    override suspend fun deleteBook(book: Book) = bookDao.deleteBook(book)
}
