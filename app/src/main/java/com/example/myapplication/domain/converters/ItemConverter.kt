package com.example.myapplication.domain.converters

import androidx.room.TypeConverter
import com.example.myapplication.domain.entities.ArmorType
import com.example.myapplication.domain.entities.Powers
import com.example.myapplication.domain.entities.WeaponType
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

class ItemConverter {
    @TypeConverter
    fun fromWeaponTypeList(weapons: MutableList<WeaponType>?): String? {
        return weapons?.let { Json.encodeToString(it) }
    }

    @TypeConverter
    fun toWeaponTypeList(weaponString: String?): MutableList<WeaponType>? {
        return weaponString?.let { Json.decodeFromString<MutableList<WeaponType>>(it) }
    }

    @TypeConverter
    fun fromArmorTypeList(armors: MutableList<ArmorType>?): String? {
        return armors?.let { Json.encodeToString(it) }
    }

    @TypeConverter
    fun toArmorTypeList(armorString: String?): MutableList<ArmorType>? {
        return armorString?.let { Json.decodeFromString<MutableList<ArmorType>>(it) }
    }

    @TypeConverter
    fun fromPowersList(powers: MutableList<Powers>?): String? {
        return powers?.let { Json.encodeToString(it) }
    }

    @TypeConverter
    fun toPowersList(powerString: String?): MutableList<Powers>? {
        return powerString?.let { Json.decodeFromString<MutableList<Powers>>(it) }
    }
}