package com.droidknights.app2021.home.ui.adapter

import com.droidknights.app2021.home.BR
import com.droidknights.app2021.home.R
import com.droidknights.app2021.home.util.DataBindingViewHolder
import com.droidknights.app2021.home.util.recyclerview.ItemDiffCallback
import com.droidknights.app2021.home.util.recyclerview.ListBindingAdapter
import com.droidknights.app2021.shared.model.Event

internal class EventAdapter(
    events: List<Event>,
    private val itemHandler: ItemHandler
) : ListBindingAdapter<Event>(ItemDiffCallback(
    onItemsTheSame = { old, new -> old.date == new.date },
    onContentsTheSame = { old, new -> old == new }
)) {
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

    fun interface ItemHandler {
        fun clickEvent(event: Event)
    }
}