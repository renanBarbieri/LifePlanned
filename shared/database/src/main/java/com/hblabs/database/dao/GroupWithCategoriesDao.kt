package com.hblabs.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.hblabs.database.entities.GroupWithCategories

@Dao
interface GroupWithCategoriesDao {

    @Transaction
    @Query("SELECT * FROM `Group`")
    fun getGroupsWithCategories(): List<GroupWithCategories>

    @Transaction
    @Query("SELECT * FROM `Group` WHERE uid == :groupId")
    fun getGroupWithCategories(groupId: Long): List<GroupWithCategories>
}