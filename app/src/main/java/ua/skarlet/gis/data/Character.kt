/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.data

import ua.skarlet.gis.data.enumeration.Element

data class Character(
    val name: String,
    val level: Int,
    val elementType: Element,
    val baseHP: Int,
    val baseATK: Int,
    val baseDEF: Int,
    val elementalMastery: Int = 0,
    val critRate: Float = 5.0f,
    val critDamage: Float = 50.0f,
    val elementalDamageBonus: Float = 0.0f,
    val physDamageBonus: Float = 0.0f,
    val reduceCD: Float = 100.0f,
    val energyRecharge: Float = 100.0f,
    val healingBonus: Float = 0.0f,
    val powerfulShield: Float = 0.0f
)