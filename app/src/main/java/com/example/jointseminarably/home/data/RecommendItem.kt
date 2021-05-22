package com.example.jointseminarably.home.data

data class RecommendItem(
    var image: Int,
    var like: Boolean,
    var saleFlag: Boolean,
    var sale: String,
    var price: String,
    var brandName: String,
    var productName: String,
    var reviewCount: Int,
    var satisfaction: Int,
)
