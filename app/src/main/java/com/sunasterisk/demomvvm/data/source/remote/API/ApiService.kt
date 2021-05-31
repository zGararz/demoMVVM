package com.sunasterisk.demomvvm.data.source.remote.API

import com.sunasterisk.demomvvm.data.model.Book
import com.sunasterisk.demomvvm.data.model.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("new")
    suspend fun getNewBooks(): BooksResponse

    @GET("books/{id}")
    suspend fun getBook(@Path("id") id: String): Book
}
