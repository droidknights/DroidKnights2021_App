package com.droidknights.app2021.home.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.droidknights.app2021.core.ui.dp2px

class SponsorItemDecoration : RecyclerView.ItemDecoration() {

    private val decorationSize = 10.dp2px()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        with(outRect) {
            left = decorationSize
            right = decorationSize
        }
    }
}