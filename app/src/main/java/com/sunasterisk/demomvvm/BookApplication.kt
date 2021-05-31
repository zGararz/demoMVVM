package com.sunasterisk.demomvvm

import android.app.Application
import com.sunasterisk.demomvvm.di.databaseModule
import com.sunasterisk.demomvvm.di.networkModule
import com.sunasterisk.demomvvm.di.sourceModule
import com.sunasterisk.demomvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BookApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BookApplication)
            modules(listOf(networkModule, viewModelModule, sourceModule, databaseModule))
        }
    }
}
