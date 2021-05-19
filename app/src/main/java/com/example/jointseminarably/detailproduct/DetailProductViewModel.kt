package com.example.jointseminarably.detailproduct

import androidx.lifecycle.ViewModel


@HiltViewModel
class DetailProductViewModel @Inject constructor(
    private val reviewRepository: ReviewRepository
): ViewModel() {
    private val _ProductList = MutableLiveData<ProductModel>()
    val productList: LiveData<ProductModel>
        get() = _ProductList

    private val _shipInfo = MutableLiveData<List<ShipInfoModel>>()
    val shipInfo: LiveData<List<ShipInfoModel>>
        get() = _shipInfo

    init {
        getProductInfo()
    }

    private fun getProductInfo() {
        _ProductList.postValue(reviewRepository.getReviewList())
    }

    fun mapShippingInfo() {
        val shipInfo  = listOf<ShipInfoModel>(
            ShipInfoModel(
                "배송정보",
                productList.value?.shipInfo
            ),
            ShipInfoModel(
                "배송비",
                productList.value?.shipCost
            ),
            ShipInfoModel(
                "배송기간",
                productList.value?.shipPeriod
            )
        )
        _shipInfo.postValue(shipInfo)
    }
}