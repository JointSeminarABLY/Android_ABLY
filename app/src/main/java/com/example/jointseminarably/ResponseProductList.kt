package com.example.jointseminarably

import com.google.gson.annotations.SerializedName

data class ResponseProductList(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Product
) {
    data class Product(
        @SerializedName("Product")
        val productList: List<ProductData>
    )

}