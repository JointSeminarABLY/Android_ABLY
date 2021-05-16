package com.example.jointseminarably.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _pageIdx: MutableLiveData<Int> = MutableLiveData(0)
    val pageIdx: LiveData<Int>
        get() = _pageIdx

    fun changePageIdx(idx: Int) {
        if(pageIdx.value != idx) _pageIdx.value = idx
    }
}