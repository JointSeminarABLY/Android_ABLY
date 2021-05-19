package com.example.jointseminarably

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel

@BindingAdapter("app:useCircleOutlineWithRadius")
fun ShapeableImageView.useCircleOutlineWithRadius(radius: Float) {
    shapeAppearanceModel = ShapeAppearanceModel().withCornerSize(radius)
}

@BindingAdapter("loadImage")
fun ImageView.loadImage(drawable: Int) {
    load(drawable)
}

@BindingAdapter("setDeliveryPercent")
fun TextView.setPercentageFormat(percentage: Int) {
    text = percentage.toString()
    append("%")
}

@BindingAdapter("datePossible", "percentage")
fun TextView.setHeaderPercentage(date: String?, percentage: Int?) {
    if(date != null) {
        text = "$date 도착확률 ${percentage}%"
    }
}
