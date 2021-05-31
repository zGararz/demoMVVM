package com.sunasterisk.demomvvm.di

import com.sunasterisk.demomvvm.ui.detail.BookDetailViewModel
import com.sunasterisk.demomvvm.ui.favorite.FavoriteBookViewModel
import com.sunasterisk.demomvvm.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { BookDetailViewModel(get()) }
    viewModel { FavoriteBookViewModel(get()) }
}
