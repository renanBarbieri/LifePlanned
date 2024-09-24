package com.hblabs.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.hblabs.database.entities.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM `Category`")
    fun getAll(): List<Category>
}