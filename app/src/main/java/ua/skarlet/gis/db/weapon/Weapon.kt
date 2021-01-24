/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db.weapon

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ua.skarlet.gis.data.Stat
import ua.skarlet.gis.data.enumeration.WeaponType
import ua.skarlet.gis.db.constants.*

@Entity(tableName = Table.WEAPONS)
data class Weapon(
    @ColumnInfo(name = WEAPON_TYPE) val type: WeaponType,
    @ColumnInfo(name = NAME) val name: String,
    @ColumnInfo(name = LVL) val level: Int,
    @ColumnInfo(name = BASE_ATK) val baseATK: Int,
    @ColumnInfo(name = SUB_STAT) val subStat: Stat,
    @ColumnInfo(name = SUB_STAT_RATE) val subStatRate: Float/*,
    @ColumnInfo(name = ABILITIES) val abilities: List<WeaponAbility> = emptyList()*/
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var uid: Int = 0
}