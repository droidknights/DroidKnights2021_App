package com.droidknights.app2021.home.databinding.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.droidknights.app2021.home.ui.SponsorItemDecoration
import com.droidknights.app2021.home.ui.adapter.SponsorAdapter
import com.droidknights.app2021.home.util.clearItemDecoration
import com.droidknights.app2021.shared.model.Sponsor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate

private const val SCROLL_DX = 5

@BindingAdapter("sponsors", "itemHandler", "coroutineScope")
fun RecyclerView.bindSponsors(
    items: List<Sponsor>?,
    itemHandler: SponsorAdapter.ItemHandler,
    coroutineScope: CoroutineScope?
) {
    clearItemDecoration()
    if (items?.isNotEmpty() == true) {
        adapter = SponsorAdapter((items + items), itemHandler)
        addItemDecoration(SponsorItemDecoration())
    }

    coroutineScope?.launch {
        launchAutoScroll()
    }
}

private tailrec suspend fun RecyclerView.launchAutoScroll() {
    smoothScrollBy(SCROLL_DX, 0)
    val firstVisibleItem =
        (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
    if (firstVisibleItem != RecyclerView.NO_POSITION) {
        if (firstVisibleItem != 0) {
            val currentList = (adapter as SponsorAdapter).currentList
            val secondPart = currentList.subList(0, 1)
            val firstPart = currentList.subList(1, currentList.size)
            (adapter as SponsorAdapter).submitList(firstPart + secondPart)
        }
    }
    delay(25L)
    launchAutoScroll()
}

@BindingAdapter("eventTitle")
fun TextView.bindEventTitle(date: LocalDate) {
    text = "${date.year}년 드로이드 나이츠"
}

@BindingAdapter("bindEventDate")
fun TextView.bindEventDate(date: LocalDate) {
    text = "${date.year}년 ${date.monthNumber}월 ${date.dayOfMonth}일"
}
