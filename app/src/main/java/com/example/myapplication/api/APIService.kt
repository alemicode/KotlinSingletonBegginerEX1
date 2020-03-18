package com.example.myapplication.api

import com.example.myapplication.models.User
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface APIService {


    @GET("placeholder/user/{userId}")
    fun getUserById(
        @Path("userId") userId: String
    ):User


}