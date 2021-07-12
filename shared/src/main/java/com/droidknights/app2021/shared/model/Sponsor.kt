package com.droidknights.app2021.shared.model

import kotlinx.serialization.Serializable

@Serializable
data class Sponsor(
    val name: String,
    val photoUrl: String,
    val homepage: String
)