package com.example.myapplication.domain.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.domain.entities.Champion
import kotlinx.coroutines.flow.Flow

@Dao
interface ChampionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: Champion)

    @Update
    suspend fun update(user: Champion)

    @Delete
    suspend fun delete(user: Champion)

    @Query("SELECT * FROM Champion WHERE id = :championId")
    fun getChampionById(championId: Long): Flow<Champion>

    @Query("SELECT * FROM Champion ORDER BY name ASC")
    fun getAllChampions(): Flow<List<Champion>>
}