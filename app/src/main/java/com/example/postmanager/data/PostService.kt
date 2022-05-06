package com.example.postmanager.data

import retrofit2.Response
import retrofit2.http.*

interface PostService {
    @Headers("app-id: 623c2e74527ddda0cdf4f6a2", "content-type: application/json")
    @GET("post")
    suspend fun getPostjson(
        @Query("page") pageNumber: Int,
        @Query("limit") postsNumber: Int
    ): Response<Posts>

    @Headers("app-id: 623c2e74527ddda0cdf4f6a2", "content-type: application/json")
    @GET("post/{post}")
    suspend fun getPost(
        @Path("post") postId: String
    ): Response<Postdata>

    @Headers("app-id: 623c2e74527ddda0cdf4f6a2", "content-type: application/json")
    @GET("tag/{tag}/post")
    suspend fun getPostsByTag(
        @Path("tag") tag: String,
        @Query("limit") postsNumber: Int
    ): Response<Posts>

    @Headers("app-id: 623c2e74527ddda0cdf4f6a2", "content-type: application/json")
    @DELETE("post/{post}")
    suspend fun deletePost(
        @Path("post") postId: String
    ): Response<Delete>

    @FormUrlEncoded
    @Headers("app-id: 623c2e74527ddda0cdf4f6a2", "content-type: application/json")
    @POST("post/create")
    suspend fun createPost(
        @Field("text") text: String,
        @Field("image") image: String,
        @Field("likes") likes: Int,
        @Field("tags") tags: ArrayList<String>,
        @Field("owner") owner: String,
    ): Response<Data>
}