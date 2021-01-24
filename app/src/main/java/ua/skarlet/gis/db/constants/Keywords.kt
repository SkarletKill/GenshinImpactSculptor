/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db.constants

// database
const val DB_NAME = "gis_db"


// fields
const val ID ="uid"

// character
const val NAME ="name"
const val LVL ="level"
const val VISION ="vision"
const val BASE_HP ="baseHP"
const val BASE_ATK ="baseATK"
const val BASE_DEF ="baseDEF"
const val ELEMENTAL_MASTERY ="elementalMastery"
const val CRIT_RATE ="critRate"
const val CRIT_DMG ="critDamage"
const val ELEMENTAL_DMG_BONUS ="elementalDamageBonus"
const val PHYS_DMG_BONUS ="physDamageBonus"
const val REDUCE_CD ="reduceCD"
const val ENERGY_RECHARGE ="energyRecharge"
const val HEALING_BONUS ="healingBonus"
const val POWERFUL_SHIELD ="powerfulShield"

// weapon
const val WEAPON_TYPE = "weapon_type"
const val SUB_STAT = "subStat"
const val SUB_STAT_RATE = "subStatRate"
const val ABILITIES = "abilities"

// queries
const val SELECT_ALL = "SELECT * FROM"
const val BY_ID = "WHERE $ID == :itemId"