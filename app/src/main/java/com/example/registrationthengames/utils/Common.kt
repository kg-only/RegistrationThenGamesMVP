package com.example.registrationthengames.utils

import com.example.registrationthengames.retrofit.RetrofitClient
import com.example.registrationthengames.retrofit.RetrofitService

object Common {
    private const val BASE_URL = "https://api.rawg.io/api/"
    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}
//https://api.rawg.io/api/platforms?key=dc24ec5ed0254d4fa10e77d570b4f11c