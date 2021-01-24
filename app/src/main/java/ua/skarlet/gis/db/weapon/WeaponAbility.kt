/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.db.weapon

import ua.skarlet.gis.data.Stat

/**
 * @param magnitude the multiplier which indicates how match the ability boost the [stat], sometimes
 * it can be quite a relative indicator. Should be from 1.0.
 * @param frequency indicates how often the ability will work, quite a relative indicator,
 * because it is very difficult to calculate the real damage with relative indicators.
 * Should be in range from 0.0 to 1.0.
 */
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