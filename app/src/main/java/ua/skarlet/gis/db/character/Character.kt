/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db.character

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ua.skarlet.gis.data.Stat
import ua.skarlet.gis.data.enumeration.Element
import ua.skarlet.gis.db.constants.*
import ua.skarlet.gis.db.constants.Table.CHARACTERS

@Entity(tableName = CHARACTERS)
data class Character(
    @ColumnInfo(name = NAME) val name: String,
    @ColumnInfo(name = LVL) val level: Int,
    @ColumnInfo(name = ELEMENT_TYPE) val elementType: Element,
    @ColumnInfo(name = BASE_HP) val baseHP: Int,
    @ColumnInfo(name = BASE_ATK) val baseATK: Int,
    @ColumnInfo(name = BASE_DEF) val baseDEF: Int,
    @ColumnInfo(name = ELEMENTAL_MASTERY) val elementalMastery: Int = Stat.ElementalMastery().value,
    @ColumnInfo(name = CRIT_RATE) val critRate: Float = Stat.CritRate().value,
    @ColumnInfo(name = CRIT_DMG) val critDamage: Float = Stat.CritDMG().value,
    @ColumnInfo(name = ELEMENTAL_DMG_BONUS) val elementalDamageBonus: Float = Stat.ElementalDMG(elementType).value,
    @ColumnInfo(name = PHYS_DMG_BONUS) val physDamageBonus: Float = Stat.PhysDMG().value,
    @ColumnInfo(name = REDUCE_CD) val reduceCD: Float = Stat.ReduceCD().value,
    @ColumnInfo(name = ENERGY_RECHARGE) val energyRecharge: Float = Stat.EnergyRecharge().value,
    @ColumnInfo(name = HEALING_BONUS) val healingBonus: Float = Stat.HealingBonus().value,
    @ColumnInfo(name = POWERFUL_SHIELD) val powerfulShield: Float = Stat.PowerfulShield().value
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var uid: Int = 0
}