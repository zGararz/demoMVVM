package com.sunasterisk.demomvvm.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunasterisk.demomvvm.data.model.BookPreview
import com.sunasterisk.demomvvm.data.repository.BooksRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: BooksRepository) : ViewModel() {
    private val _books = MutableLiveData<List<BookPreview>>()
    val books: LiveData<List<BookPreview>> get() = _books

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val handlerException = CoroutineExceptionHandler { _, throwable ->
        _error.postValue(throwable.toString())
    }

    fun getNewBooks() {
        viewModelScope.launch(Dispatchers.IO + handlerException) {
            _books.postValue(repository.getNewsBook().books)
        }
    }
}
