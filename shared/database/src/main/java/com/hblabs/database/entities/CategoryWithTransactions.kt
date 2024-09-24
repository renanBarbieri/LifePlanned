package com.hblabs.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryWithTransactions(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "uid",
        entityColumn = "categoryId"
    )
    val transactions: List<Transaction>
)
