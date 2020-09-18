package com.gok.androidapp.api

import com.gok.androidapp.models.MainModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GokApi{

    @GET("sandbox/products")
    public fun getData(): Call<MainModel>
}