package com.example.jointseminarably.detailproduct

import com.example.jointseminarably.R
import io.reactivex.Single

class ReviewDataSourceImpl : ReviewDataSource {
    override fun getReviewList(): Single<ProductModel> =
        Single.just(
            ProductModel(
                IMAGE_LIST,
                "[기획특가/무료배송] 빌즈 썸머 밴딩코튼팬츠 - 5 color",
                16000,
                REVIEW_LIST,
                "마켓 자체 배송",
                "무료",
                "5/15(토)이내 도착예상 76%"
            )
        )

    companion object {
        private val IMAGE_LIST = arrayListOf<Int>(
            R.drawable.photo_pants,
            R.drawable.photo_pants,
            R.drawable.photo_pants,
            R.drawable.photo_pants
        )
        private val REVIEW_LIST = listOf(
            ReviewModel(
                R.drawable.pants_1,
                "바지가 너무너무 편해요",
                "솔직히 기대 안 했는데 핏 좋고 정말 맘에 들었어요 또 얇아서 여름에도 매일 입을 것 같아요!!!!"
            ),
            ReviewModel(
                R.drawable.rectangle_28,
                "바지가 너무너무 편해요",
                "솔직히 기대 안 했는데 핏 좋고 정말 맘에 들었어요 또 얇아서 여름에도 매일 입을 것 같아요!!!!"
            )
        )
    }
}