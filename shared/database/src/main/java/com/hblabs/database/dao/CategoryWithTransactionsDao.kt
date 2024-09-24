package com.hblabs.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.hblabs.database.entities.CategoryWithTransactions

@Dao

interface CategoryWithTransactionsDao {
    @Transaction
    @Query("SELECT * FROM `Category`")
    fun getCategoriesWithTransactions(): List<CategoryWithTransactions>

    @Transaction
    @Query("SELECT * FROM `Category` WHERE uid == :categoryId")
    fun getCategoryWithTransactions(categoryId: Long): List<CategoryWithTransactions>
}