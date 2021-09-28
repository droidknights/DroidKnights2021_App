package com.droidknights.app2021.home.databinding.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import kotlinx.datetime.LocalDate

@BindingAdapter("eventTitle")
fun TextView.bindEventTitle(date: LocalDate) {
    text = "${date.year}년 드로이드 나이츠"
}

@BindingAdapter("bindEventDate")
fun TextView.bindEventDate(date: LocalDate) {
    text = "${date.year}년 ${date.monthNumber}월 ${date.dayOfMonth}일"
}
