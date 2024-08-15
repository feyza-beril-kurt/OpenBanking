package com.example.akbank

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BankList(
    val bankList: List<Banks> = emptyList()
) : Parcelable
