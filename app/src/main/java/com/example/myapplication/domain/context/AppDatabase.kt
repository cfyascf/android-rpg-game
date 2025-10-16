package com.example.myapplication.domain.context

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.domain.daos.ChampionDao
import com.example.myapplication.domain.entities.Champion

@Database(entities = [Champion::class], version = 1, exportSchema = false)
@TypeConverters(DatabaseConverters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun championDao(): ChampionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, "app_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}