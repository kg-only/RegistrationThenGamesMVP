package com.example.registrationthengames.main.api

import com.example.registrationthengames.responseModel.ResponseApi
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("games?key=dc24ec5ed0254d4fa10e77d570b4f11c")
    suspend fun getGames(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int,
        @Query("genres") genre: String? = null,
    ): ResponseApi
}
//https://api.rawg.io/api/platforms?key=dc24ec5ed0254d4fa10e77d570b4f11c
//https://api.rawg.io/api/key=dc24ec5ed0254d4fa10e77d570b4f11c