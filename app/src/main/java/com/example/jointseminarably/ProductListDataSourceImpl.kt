package com.example.jointseminarably

import io.reactivex.Single
import javax.inject.Inject

class ProductListDataSourceImpl @Inject constructor(
    private val productListService: ProductListService
): ProductListDataSource {
    override fun getProductList(): Single<ResponseProductList> =
        productListService.getProductInfo()
}