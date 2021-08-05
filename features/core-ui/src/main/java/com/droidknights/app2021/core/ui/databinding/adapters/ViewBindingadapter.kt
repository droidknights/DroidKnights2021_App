package com.droidknights.app2021.core.ui.databinding.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imgUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    imageView.load(url) {
        crossfade(true)
    }
}