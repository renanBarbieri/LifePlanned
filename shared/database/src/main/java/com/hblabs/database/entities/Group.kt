package com.hblabs.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Group(
    @PrimaryKey val uid: Long,
    val name: String
)