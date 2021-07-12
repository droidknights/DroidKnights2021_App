package com.droidknights.app2021.home.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.droidknights.app2021.home.R

internal class HeaderAdapter : RecyclerView.Adapter<HeaderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        return HeaderViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {}

    override fun getItemCount(): Int = 1
}

internal class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    companion object {
        fun newInstance(parent: ViewGroup): HeaderViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_header_title, parent, false)
            return HeaderViewHolder(view)
        }
    }
}