package com.sunasterisk.demomvvm.data.source.remote

import com.sunasterisk.demomvvm.data.source.BooksDataSource
import com.sunasterisk.demomvvm.data.source.remote.API.ApiService

@Suppress("DEPRECATION")
class BooksRemoteDataSource(private val apiService: ApiService) : BooksDataSource.Remote {
    override suspend fun getNewsBook() = apiService.getNewBooks()
    override suspend fun getRemoteBook(id: String) = apiService.getBook(id)
}
