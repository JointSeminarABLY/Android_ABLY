package com.example.jointseminarably.detailproduct

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RVItemDecoration(
    private val _top: Int,
    private val _right: Int,
    private val _bottom: Int,
    private val _left: Int,
) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        with(outRect) {
            right = _right // 5
            bottom = _bottom // 22
            left = _left // 5
        }
    }
}