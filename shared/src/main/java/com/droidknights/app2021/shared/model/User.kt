package com.droidknights.app2021.shared.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val name: String,
    val photoUrl: String,
    val companyName: String? = null,
    val snsLink: String? = null
)
