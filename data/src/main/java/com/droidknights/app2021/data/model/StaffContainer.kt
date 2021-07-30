package com.droidknights.app2021.data.model

import com.droidknights.app2021.shared.model.User
import kotlinx.serialization.Serializable

@Serializable
internal data class StaffContainer(
    val staff: List<User> = emptyList()
)