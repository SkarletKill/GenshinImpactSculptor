/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.data

sealed class WeaponAbility(
    val stat: Stat,
    val magnitude: Float,
    val frequency: Float
) {
    class StatBoost(
        increasedStat: Stat,
        magnitude: Float,
        frequency: Float
    ) : WeaponAbility(increasedStat, magnitude, frequency)

    class DamageBoost(
        usedStat: Stat,
        magnitude: Float,
        frequency: Float
    ) : WeaponAbility(usedStat, magnitude, frequency)
}