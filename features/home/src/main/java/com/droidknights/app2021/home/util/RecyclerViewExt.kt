package com.droidknights.app2021.home.util

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.clearItemDecoration() {
    repeat(itemDecorationCount) {
        removeItemDecorationAt(0)
    }
}