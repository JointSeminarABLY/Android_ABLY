package com.example.jointseminarably.detailproduct

data class ProductModel
    (
    val image: List<Int>,
    val nameProduct: String,
    val price:Int,
    val review: List<ReviewModel>,
    val shipInfo: String,
    val shipCost: String,
    val shipPeriod: String
)