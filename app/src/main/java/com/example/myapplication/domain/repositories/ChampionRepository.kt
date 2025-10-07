package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.daos.ChampionDao
import com.example.myapplication.domain.entities.Champion

class ChampionRepository(
    private val championDao: ChampionDao
) {
    suspend fun insert(champion: Champion) {
        championDao.insert(champion)
    }
}