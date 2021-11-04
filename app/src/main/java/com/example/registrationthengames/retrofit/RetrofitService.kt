package com.example.registrationthengames.retrofit

import com.example.registrationthengames.modelGames.GameResult
import com.example.registrationthengames.modelGames.GamesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("games?key=dc24ec5ed0254d4fa10e77d570b4f11c")
        fun getGames(
    @Query("page") page: Int,
    @Query("page_size") pageSize: Int,
//    @Query("developers") developers: String? = null,
//    @Query("publishers") publisher: String? = null,
    @Query("genres") genre: String? = null
    ): Call<GamesResponse>
}
//https://api.rawg.io/api/platforms?key=dc24ec5ed0254d4fa10e77d570b4f11c
