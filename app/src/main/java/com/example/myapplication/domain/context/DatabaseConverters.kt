package com.example.myapplication.domain.context

import androidx.room.TypeConverter
import com.example.myapplication.domain.abstractions.Archetype
import com.example.myapplication.domain.abstractions.Race
import com.example.myapplication.domain.entities.archetypes.*
import com.example.myapplication.domain.entities.races.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

class DatabaseConverters {
    private val json = Json {
        serializersModule = SerializersModule {

            polymorphic(Race::class) {
                subclass(Dwarf::class)
                subclass(Elf::class)
                subclass(Human::class)
            }

            polymorphic(Archetype::class) {
                subclass(Archer::class)
                subclass(Mage::class)
                subclass(Warrior::class)
            }
        }
        ignoreUnknownKeys = true
    }

    @TypeConverter
    fun fromRace(race: Race): String {
        return json.encodeToString(Race.serializer(), race)
    }

    @TypeConverter
    fun toRace(jsonString: String): Race {
        return json.decodeFromString(Race.serializer(), jsonString)
    }


    @TypeConverter
    fun fromArchetype(archetype: Archetype): String {
        return json.encodeToString(Archetype.serializer(), archetype)
    }

    @TypeConverter
    fun toArchetype(jsonString: String): Archetype {
        return json.decodeFromString(Archetype.serializer(), jsonString)
    }
}