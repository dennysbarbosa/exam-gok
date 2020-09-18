package com.gok.androidapp.network

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConnection{

    private val TAG = "GokAndroidApp"

    fun connection(url: String): Retrofit{

        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json").build()
                val reponse = chain.proceed(requestBuilder)
                Log.i(
                    TAG,"final request url: " + reponse.request().url()
                )
                Log.i(TAG,"message response" + reponse.message()
                )
                Log.i(TAG,"Response Code: " + reponse.code()
                )
                reponse
            }.build()

        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(client)
            .build()
    }

}