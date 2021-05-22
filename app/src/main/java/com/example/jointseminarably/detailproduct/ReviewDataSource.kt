package com.example.jointseminarably.detailproduct

import io.reactivex.Single

interface ReviewDataSource {
    fun getReviewList() : Single<ProductModel>
}