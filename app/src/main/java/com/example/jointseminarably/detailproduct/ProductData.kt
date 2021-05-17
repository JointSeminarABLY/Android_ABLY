package com.example.jointseminarably.detailproduct

data class ProductData(
    val discount: String,
    val price: String,
    val detail: String,
    val pic: Int,
    var clicked: Boolean = false,
)