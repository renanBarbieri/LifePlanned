package com.hblabs.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class GroupWithCategories(
    @Embedded val group: Group,
    @Relation(
        parentColumn = "uid",
        entityColumn = "groupId"
    )
    val categories: List<Category>
)
