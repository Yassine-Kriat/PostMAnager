package com.example.postmanager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postmanager.data.*
import kotlinx.coroutines.launch
import retrofit2.Response

// ini Api final functions
class MainViewModel(private val repository: PostRepository): ViewModel() {
    val myResponse: MutableLiveData<Response<Posts>> = MutableLiveData()
    val myPostResponse: MutableLiveData<Response<Postdata>> = MutableLiveData()
    val myDeletePostResponse: MutableLiveData<Response<Delete>> = MutableLiveData()
    val myCreatePostResponse: MutableLiveData<Response<Data>> = MutableLiveData()


    fun getPosts(pageNumber: Int, postsNumber: Int) {
        viewModelScope.launch {
            val response = repository.getPosts(pageNumber, postsNumber)
            myResponse.value = response
        }
    }

    fun getPost(postId: String) {
        viewModelScope.launch {
            val response = repository.getPost(postId)
            myPostResponse.value = response
        }
    }

    fun getPostsByTag(tag: String, postsNumber: Int) {
        viewModelScope.launch {
            val response = repository.getPostsByTag(tag, postsNumber)
            myResponse.value = response
        }
    }

    fun deletePost(postId: String) {
        viewModelScope.launch {
            val response = repository.deletePost(postId)
            myDeletePostResponse.value = response
        }
    }

    fun createPost(text: String, image: String,likes: Int, tags: ArrayList<String>, owner: String) {
        viewModelScope.launch {
            val response = repository.createPost(text, image,likes, tags ,owner)
            myCreatePostResponse.value = response
        }
    }
}
