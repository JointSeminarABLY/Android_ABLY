package com.example.jointseminarably

import io.reactivex.Single
import retrofit2.http.GET

interface ProductListService {
    @GET("Product/")
    fun getProductInfo(): Single<ResponseProductList>
}