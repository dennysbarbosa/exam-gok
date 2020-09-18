package com.gok.androidapp.models

import com.google.gson.annotations.SerializedName

class MainModel {

    @SerializedName("spotlight")
    lateinit var listSpotlightModel: List<SpotlightModel>

    @SerializedName("products")
    lateinit var listProductModel: List<ProductModel>

    @SerializedName("cash")
    lateinit var cashModel: CashModel
}