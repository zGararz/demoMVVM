package com.sunasterisk.demomvvm.data.source.local.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sunasterisk.demomvvm.data.model.Book
import com.sunasterisk.demomvvm.data.source.local.dao.BookDao

@Database(entities = [Book::class], version = BooksDatabase.VERSION, exportSchema = true)
abstract class BooksDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        const val DATABASE_NAME = "itbook"
        const val VERSION = 1
    }
}
