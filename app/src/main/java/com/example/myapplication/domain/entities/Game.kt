package com.example.myapplication.domain.entities

class Game {
    companion object {
        @Volatile
        private var INSTANCE: Game? = null

        fun getCurrentGame(): Game =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Game().also { INSTANCE = it }
            }

        fun newGame(): Game? {
            INSTANCE = Game()
            return INSTANCE
        }
    }
    val champion: Champion? = null
}