package com.droidknights.app2021.home.compose.adapters

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.droidknights.app2021.home.util.recyclerview.ItemDiffCallback

abstract class ComposeListAdapter<T, V : ComposeViewHolder<T>>(
    diffCallback: ItemDiffCallback<T>
) : ListAdapter<T, V>(diffCallback) {
    override fun onViewRecycled(holder: V) {
        holder.composeView.disposeComposition()
        super.onViewRecycled(holder)
    }
}

abstract class ComposeViewHolder<T>(
    val composeView: ComposeView
) : RecyclerView.ViewHolder(composeView) {

    @Composable
    abstract fun ViewHolder(input: T)

    init {
        composeView.setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
        )
    }

    fun onBind(data: T) {
        composeView.setContent {
            ViewHolder(data)
        }
    }
}