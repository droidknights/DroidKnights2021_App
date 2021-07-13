package com.droidknights.app2021.home.databinding.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.droidknights.app2021.home.ui.SponsorItemDecoration
import com.droidknights.app2021.home.ui.adapter.SponsorAdapter
import com.droidknights.app2021.home.util.clearItemDecoration
import com.droidknights.app2021.shared.model.Sponsor
import kotlinx.datetime.LocalDate

@BindingAdapter("sponsors", "itemHandler")
fun RecyclerView.bindSponsors(items: List<Sponsor>?, itemHandler: SponsorAdapter.ItemHandler) {
    clearItemDecoration()
    if (items?.isNotEmpty() == true) {
        adapter = SponsorAdapter(items, itemHandler)
        addItemDecoration(SponsorItemDecoration())
    }
}

@BindingAdapter("eventTitle")
fun TextView.bindEventTitle(date: LocalDate) {
    text = "${date.year}년 드로이드 나이츠"
}

@BindingAdapter("bindEventDate", "bindEndEvent")
fun TextView.bindEventDate(date: LocalDate, isEndEvent: Boolean) {
    text = if (isEndEvent) {
        "${date.year}년 ${date.monthNumber}월 ${date.dayOfMonth}일"
    } else {
        "${date.year}년 ${date.monthNumber}월 예정"
    }
}
