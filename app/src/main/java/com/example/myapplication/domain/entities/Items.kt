package com.example.myapplication.domain.entities

import kotlinx.serialization.Serializable

@Serializable
enum class WeaponType {
    SWORD,
    SHORT_SWORD,
    DAGGER,
    STAFF,
    CROSSBOW,
    SLING,
    BOW,
    CLUB,
    MACE,
    HAMMER
}

@Serializable
enum class ArmorType {
    NONE,
    LIGHT,
    MEDIUM,
    HEAVY,
    SHIELD
}