package com.enescanpolat.sorucevap.data.datasource

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {
    const val BASE_URL = "https://api.openai.com/"

    private val httpClient = OkHttpClient.Builder()
        .build()

    private val retrofit=Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService:OpenAiAPI = retrofit.create(OpenAiAPI::class.java)


}