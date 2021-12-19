package com.example.registrationthengames.main.api

//object RetrofitClient {
//    //https://api.rawg.io/api/platforms?key=dc24ec5ed0254d4fa10e77d570b4f11c
//    private var retrofit: Retrofit? = null
//
//    fun getClient(baseUrl: String): Retrofit {
//        val interceptor = HttpLoggingInterceptor()//read about this
//        interceptor.level = HttpLoggingInterceptor.Level.BODY//read about this
//        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
//        if (retrofit == null) {
//            retrofit = Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build()
//        }
//        return retrofit!!
//    }
//}
