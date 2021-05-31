package com.sunasterisk.demomvvm.di

import com.sunasterisk.demomvvm.Ultils.BASE_URL
import com.sunasterisk.demomvvm.data.source.remote.API.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { initRetrofit() }
    single { createApiService(get()) }
}

fun initRetrofit(): Retrofit? = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

fun createApiService(retrofit: Retrofit): ApiService? = retrofit.create(ApiService::class.java)
