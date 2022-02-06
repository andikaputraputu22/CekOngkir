package com.moonlightsplitter.cekongkir.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    private const val BASE_URL = "https://pro.rajaongkir.com/api/"
    private const val RAJAONGKIR_KEY = "82aab7e0170e3e31f9a2da7b61ef4bab"

    val instance: Api by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("key", RAJAONGKIR_KEY).build()
                chain.proceed(request)
            }
            .build()

        val gson = GsonBuilder().serializeNulls().create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

        retrofit.create(Api::class.java)
    }
}