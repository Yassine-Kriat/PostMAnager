package com.example.postmanager.data

data class Posts(
    val `data`: List<Data>,
    val limit: Int,
    val page: Int,
    val total: Int
)