package com.example.jointseminarably

import io.reactivex.Single

interface ProductListDataSource {
    fun getProductList(): Single<ResponseProductList>
}