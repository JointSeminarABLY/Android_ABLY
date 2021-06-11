package com.example.jointseminarably.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jointseminarably.ProductData
import com.example.jointseminarably.ProductListDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val datasource: ProductListDataSource
): ViewModel() {
    private val _productList = MutableLiveData<List<ProductData>>()
    val productList: LiveData<List<ProductData>>
        get() = _productList


    @SuppressLint("CheckResult")
    fun fetchProductList() {
        datasource.getProductList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _productList.postValue(it.data.productList)
                Log.e("success", it.data.toString())
            }, {
                Log.e("error", it.message.toString())
            })
    }
}