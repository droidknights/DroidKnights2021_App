package com.droidknights.app2021.home.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.droidknights.app2021.ui.core.dp2px

class SponsorItemDecoration : RecyclerView.ItemDecoration() {

    private val edgeSize = 16.dp2px()
    private val middleSize = 10.dp2px()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val adapter = parent.adapter ?: return

        val count = adapter.itemCount

        when (parent.getChildAdapterPosition(view)) {
            0 -> {
                outRect.left = edgeSize
                outRect.right = middleSize
            }
            count - 1 -> {
                outRect.left = middleSize
                outRect.right = middleSize
            }
            else -> {
                outRect.left = middleSize
                outRect.right = edgeSize
            }
        }
    }
}