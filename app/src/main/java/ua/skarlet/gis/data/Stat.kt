/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.data

import androidx.annotation.StringRes
import com.skarlet.gis.R
import ua.skarlet.gis.data.enumeration.Vision

sealed class Stat(
    @StringRes var stringRes: Int,
    open val value: Number
) {
    class Level(
        override var value: Int = 0
    ) : Stat(R.string.level, value)

    class ATK(
        override val value: Int = 0
    ) : Stat(R.string.attack, value)

    class DEF(
        override val value: Int = 0
    ) : Stat(R.string.defense, value)

    class HP(
        override val value: Int = 0
    ) : Stat(R.string.health, value)

    class ElementalMastery(
        override val value: Int = 0
    ) : Stat(R.string.elemental_mastery, value)

    class ElementalDMG(
        private val vision: Vision,
        override val value: Float = 0f
    ) : Stat(R.string.elemental_damage_bonus, value)

    class PhysDMG(
        override val value: Float = 0f
    ) : Stat(R.string.phys_damage_bonus, value)

    class CritRate(
        override val value: Float = 5.0f
    ) : Stat(R.string.crit_rate, value)

    class CritDMG(
        override val value: Float = 50.0f
    ) : Stat(R.string.crit_dmg, value)

    class ReduceCD(
        override val value: Float = 0f
    ) : Stat(R.string.reduce_cd, value)

    class EnergyRecharge(
        override val value: Float = 100.0f
    ) : Stat(R.string.energy_recharge, value)

    class HealingBonus(
        override val value: Float = 0f
    ) : Stat(R.string.healing_bonus, value)

    class PowerfulShield(
        override val value: Float = 0f
    ) : Stat(R.string.powerful_shield, value)

}