package com.hblabs.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.hblabs.database.entities.Group

@Dao
interface GroupDao {

    @Query("SELECT * FROM `Group`")
    fun getAll(): List<Group>

    @Query("SELECT * FROM `Group` WHERE name == :name LIMIT 1")
    fun getByName(name: String): Group
}