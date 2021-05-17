package com.example.jointseminarably.detailproduct

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RVItemDecoration() : RecyclerView.ItemDecoration(){
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        with(outRect){
            left = 5
            right = 5
            bottom = 22
        }
    }
}