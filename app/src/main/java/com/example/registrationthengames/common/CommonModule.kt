package com.example.registrationthengames.common

import com.example.registrationthengames.main.api.RetrofitService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.rawg.io/api/"

object CommonModule {
    fun create() = module{
        single {
            ///OkHTTP
            val interceptor = HttpLoggingInterceptor()//read about this
            interceptor.level = HttpLoggingInterceptor.Level.BODY//read about this
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            //retrofit
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build()
            retrofit.create(RetrofitService::class.java)
        }
    }
}