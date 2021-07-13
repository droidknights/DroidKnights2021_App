package com.droidknights.app2021.home.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.droidknights.app2021.home.BR
import com.droidknights.app2021.home.R
import com.droidknights.app2021.home.util.DataBindingAdapter
import com.droidknights.app2021.home.util.DataBindingViewHolder
import com.droidknights.app2021.shared.model.Event

internal class EventAdapter(
    events: List<Event>,
    private val itemHandler: ItemHandler
) : DataBindingAdapter<Event>(DiffCallback()) {
    init {
        submitList(events)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_event
    }

    override fun viewBindViewHolder(holder: DataBindingViewHolder<Event>, position: Int) {
        super.viewBindViewHolder(holder, position)
        holder.binding.setVariable(BR.itemHandler, itemHandler)
    }

    interface ItemHandler {
        fun clickEvent(event: Event)
    }

    private class DiffCallback : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }
    }
}