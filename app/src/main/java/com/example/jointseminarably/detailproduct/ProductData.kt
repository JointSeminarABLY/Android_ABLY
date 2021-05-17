package com.example.jointseminarably.detailproduct

data class ProductData(
    val discount: String,
    val price: String,
    val detail: String,
    var clicked: Boolean = false
)