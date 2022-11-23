package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/users/")
fun getUsers(): Call<MutableList<PostModel>>





}