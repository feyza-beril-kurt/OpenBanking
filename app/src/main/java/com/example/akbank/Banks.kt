package com.example.akbank

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Banks(
    val id: Int = 6,
    val imageUrl: String = "",
    val title: String = ""
) : Parcelable
