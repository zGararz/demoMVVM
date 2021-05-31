package com.sunasterisk.demomvvm.di

import android.content.Context
import androidx.room.Room
import com.sunasterisk.demomvvm.data.source.local.Database.BooksDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        initDatabase(androidContext())
    }

    single { get<BooksDatabase>().bookDao() }
}

fun initDatabase(context: Context) = Room.databaseBuilder(
    context,
    BooksDatabase::class.java,
    BooksDatabase.DATABASE_NAME
).build()
