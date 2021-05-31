package com.sunasterisk.demomvvm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunasterisk.demomvvm.data.model.Book
import com.sunasterisk.demomvvm.data.repository.BooksRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookDetailViewModel(private val repository: BooksRepository) : ViewModel() {
    private val _book = MutableLiveData<Book>()
    val book: LiveData<Book> get() = _book

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> = _isFavorite

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val handlerException = CoroutineExceptionHandler { _, throwable ->
        _error.postValue(throwable.toString())
    }

    fun loadBook(id: String) {
        getBook(id)
        getFavorite(id)
    }

    fun getBook(id: String) {

        viewModelScope.launch(Dispatchers.IO + handlerException) {
            _book.postValue(repository.getRemoteBook(id))
        }
    }

    fun setFavorite() {
        viewModelScope.launch(Dispatchers.IO + handlerException) {
            book.value?.let {
                if (isFavorite.value == true) {
                    repository.deleteBook(it)
                    _isFavorite.postValue(false)
                } else {
                    repository.insertBook(it)
                    _isFavorite.postValue(true)
                }
            }
        }
    }

    private fun getFavorite(id: String) {
        viewModelScope.launch(Dispatchers.IO + handlerException) {
            _isFavorite.postValue(repository.getBook(id) != null)
        }
    }
}
