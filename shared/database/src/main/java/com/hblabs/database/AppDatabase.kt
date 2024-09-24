package com.hblabs.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hblabs.database.dao.CategoryDao
import com.hblabs.database.dao.CategoryWithTransactionsDao
import com.hblabs.database.dao.GroupDao
import com.hblabs.database.dao.GroupWithCategoriesDao
import com.hblabs.database.entities.Category
import com.hblabs.database.entities.Group
import com.hblabs.database.entities.Transaction

@Database(
    entities = [
        Group::class,
        Category::class,
        Transaction::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun groupDao(): GroupDao
    abstract fun categoryDao(): CategoryDao
    abstract fun groupWithCategoryDao(): GroupWithCategoriesDao
    abstract fun categoryWithTransactionsDao(): CategoryWithTransactionsDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()

                INSTANCE = instance

                instance
            }
        }
    }

}