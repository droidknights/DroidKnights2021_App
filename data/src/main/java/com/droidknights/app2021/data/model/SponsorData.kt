package com.droidknights.app2021.data.model

import com.droidknights.app2021.shared.model.Sponsor
import kotlinx.serialization.Serializable

@Serializable
internal data class SponsorContainer(
    val sponsors: List<Sponsor> = emptyList()
)
