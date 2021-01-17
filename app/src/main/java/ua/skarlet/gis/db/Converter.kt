/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db

import androidx.room.TypeConverter
import ua.skarlet.gis.data.enumeration.ArtifactType
import ua.skarlet.gis.data.enumeration.Element
import ua.skarlet.gis.data.enumeration.WeaponType

class Converter {
    @TypeConverter
    fun toElementType(value: Int) = enumValues<Element>().find { it.uid == value }

    @TypeConverter
    fun fromElementType(value: Element) = value.uid

    @TypeConverter
    fun toWeaponType(value: Int) = enumValues<WeaponType>().find { it.uid == value }

    @TypeConverter
    fun fromWeaponType(value: WeaponType) = value.uid

    @TypeConverter
    fun toArtifactType(value: Int) = enumValues<ArtifactType>().find { it.uid == value }

    @TypeConverter
    fun fromArtifactType(value: ArtifactType) = value.uid
}