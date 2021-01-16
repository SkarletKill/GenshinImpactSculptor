/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.data

data class Weapon(
    val baseATK: Int,
    val subStat: Stat,
    val abilities: List<WeaponAbility>
)