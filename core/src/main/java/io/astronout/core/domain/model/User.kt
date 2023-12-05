package io.astronout.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val login: String,
    val id: Int,
    val nodeId: String,
    val avatarUrl: String,
    val type: String,
): Parcelable