/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db

import androidx.room.TypeConverter
import ua.skarlet.gis.data.Stat
import ua.skarlet.gis.data.enumeration.ArtifactType
import ua.skarlet.gis.data.enumeration.Vision
import ua.skarlet.gis.data.enumeration.WeaponType

class Converter {
    @TypeConverter
    fun toElementType(uid: Int) = Vision.byID(uid)

    @TypeConverter
    fun fromElementType(item: Vision) = item.uid

    @TypeConverter
    fun toWeaponType(uid: Int) = WeaponType.byID(uid)

    @TypeConverter
    fun fromWeaponType(item: WeaponType) = item.uid

    @TypeConverter
    fun toArtifactType(uid: Int) = ArtifactType.byID(uid)

    @TypeConverter
    fun fromArtifactType(item: ArtifactType) = item.uid

    @TypeConverter
    fun toStat(stringUid: String): Stat = Stat.DatabaseMapper.getState(stringUid)!!

    @TypeConverter
    fun fromArtifactType(item: Stat) = Stat.DatabaseMapper.getStringId(item)
}