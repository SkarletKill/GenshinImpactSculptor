/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db

import androidx.room.TypeConverter
import ua.skarlet.gis.data.enumeration.Element

class Converter {
    @TypeConverter
    fun toElementType(value: String) = enumValueOf<Element>(value)

    @TypeConverter
    fun fromElementType(value: Element) = value.name
}