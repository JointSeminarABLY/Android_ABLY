package com.example.jointseminarably

import com.google.gson.annotations.SerializedName

data class ProductData(
    @SerializedName("_id")
    val id: String,
    val name: String,
    val image: String,
    val discount: Int,
    val price: Int,
    val shop: String,
    @SerializedName("review_count")
    val reviewCount: Int,
    val satisfy: Int,
    val category: String,
    val date: String,
    val __v: Int
)