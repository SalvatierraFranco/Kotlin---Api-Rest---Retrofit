package com.example.webserviceprueba1

import retrofit2.Call
import retrofit2.http.GET

interface MyApi {
    @GET("/posts")
    fun getPosts(): Call<List<Posts>>
}