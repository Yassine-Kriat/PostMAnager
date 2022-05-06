package com.example.postmanager.data

data class Postdata (
    val id: String,
    val image: String,
    val likes: Int,
    val link: String,
    val tags: ArrayList<String>,
    val text: String,
    val publishDate: String,
    val owner: Owner
        )