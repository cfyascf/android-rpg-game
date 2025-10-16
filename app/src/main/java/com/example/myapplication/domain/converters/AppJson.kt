package com.example.myapplication.domain.converters

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.entities.archetypes.Warrior
import com.example.myapplication.domain.entities.archetypes.Mage
import com.example.myapplication.domain.entities.archetypes.Archer
import kotlinx.serialization.modules.subclass

object AppJson {
    val instance = Json {
        serializersModule = SerializersModule {
            polymorphic(Archetype::class) {
                subclass(Archer::class)
                subclass(Warrior::class)
                subclass(Mage::class)
            }
        }
        ignoreUnknownKeys = true
    }
}