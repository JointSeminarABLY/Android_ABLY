package com.example.jointseminarably.detailproduct

import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(
    private val dataSource: ReviewDataSource
): ReviewRepository {
    override fun getReviewList(): ProductModel {
        return dataSource.getReviewList().blockingGet()
    }
}