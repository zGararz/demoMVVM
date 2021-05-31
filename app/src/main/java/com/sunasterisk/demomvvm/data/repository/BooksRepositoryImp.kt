package com.sunasterisk.demomvvm.data.repository

import com.sunasterisk.demomvvm.data.model.Book
import com.sunasterisk.demomvvm.data.source.BooksDataSource

class BooksRepositoryImp(
    private val remote: BooksDataSource.Remote,
    private val local: BooksDataSource.Local
) : BooksRepository {
    override suspend fun getNewsBook() = remote.getNewsBook()
    override suspend fun getRemoteBook(id: String) = remote.getRemoteBook(id)

    override suspend fun insertBook(book: Book) = local.insertBook(book)
    override suspend fun getBook(id: String) = local.getBook(id)
    override suspend fun getAllBooks() = local.getAllBooks()
    override suspend fun deleteBook(book: Book) = local.deleteBook(book)
}
