package com.example.jointseminarably.detailproduct

import javax.inject.Inject

//Todo: 현재는 api가 안나왔기 때문에 datasource에서 더미데이터 입력해주고 blockingGet으로 그대로 뱉도록 해놓음.
class ReviewRepositoryImpl @Inject constructor(
    private val dataSource: ReviewDataSource
): ReviewRepository {
    override fun getReviewList(): ProductModel {
        return dataSource.getReviewList().blockingGet()
    }
}