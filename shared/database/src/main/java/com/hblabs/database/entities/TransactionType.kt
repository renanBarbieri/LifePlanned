package com.hblabs.database.entities

import androidx.room.PrimaryKey

data class TransactionType(
    @PrimaryKey val uid: Long,
    val name: String,
)
