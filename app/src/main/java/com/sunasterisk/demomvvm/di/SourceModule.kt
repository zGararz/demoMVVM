package com.sunasterisk.demomvvm.di

import com.sunasterisk.demomvvm.data.repository.BooksRepository
import com.sunasterisk.demomvvm.data.repository.BooksRepositoryImp
import com.sunasterisk.demomvvm.data.source.BooksDataSource
import com.sunasterisk.demomvvm.data.source.local.BooksLocalDataSource
import com.sunasterisk.demomvvm.data.source.remote.BooksRemoteDataSource
import org.koin.dsl.module

val sourceModule = module {
    single<BooksRepository> { BooksRepositoryImp(get(), get()) }
    single<BooksDataSource.Local> { BooksLocalDataSource(get()) }
    single<BooksDataSource.Remote> { BooksRemoteDataSource(get()) }
}
