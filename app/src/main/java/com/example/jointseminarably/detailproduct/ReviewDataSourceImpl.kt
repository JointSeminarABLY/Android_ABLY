package com.example.jointseminarably.detailproduct

import com.example.jointseminarably.R
import io.reactivex.Single

//Todo: 서버Api 나오면 Response만들어서 뷰에서 쓰이는 Entity와 맵핑하기, 이후 더미데이터 삭제
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
                "5/22(토)이내 도착예상 76%",
                deliveryPercentageModel
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

        private val deliveryPercentageModel = listOf<DeliveryPercentageModel>(
            DeliveryPercentageModel(
            "5/22(토)",
            76
            ),
            DeliveryPercentageModel(
                "5/24(월)",
                85
            ),
            DeliveryPercentageModel(
                "5/25(화)",
                100
            )
        )
    }
}