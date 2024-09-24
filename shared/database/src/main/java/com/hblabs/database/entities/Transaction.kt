package com.hblabs.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Transaction(
    @PrimaryKey
    val uid: Long,
    @ColumnInfo
    val createdDate: Long,
    val value: Long,
    val categoryId: Long,
    val transactionTypeId: Long
)
