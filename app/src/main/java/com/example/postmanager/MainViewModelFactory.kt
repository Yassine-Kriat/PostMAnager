package com.example.postmanager

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.postmanager.data.PostRepository

//ini MainViewModelFactory
class MainViewModelFactory(private val repository: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}