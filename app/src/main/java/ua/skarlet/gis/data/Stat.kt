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
        override var value: Int = 1
    ) : Stat(R.string.level, value)

    class ATK(
        override val value: Int = 0
    ) : Stat(R.string.attack, value)

    class ATK_RATE(
        override val value: Float = 0.0f
    ) : Stat(R.string.attack_rate, value)

    class DEF(
        override val value: Int = 0
    ) : Stat(R.string.defense, value)

    class DEF_RATE(
        override val value: Float = 0.0f
    ) : Stat(R.string.defense_rate, value)

    class HP(
        override val value: Int = 0
    ) : Stat(R.string.health, value)

    class HP_RATE(
        override val value: Float = 0.0f
    ) : Stat(R.string.health_rate, value)

    class ElementalMastery(
        override val value: Int = 0
    ) : Stat(R.string.elemental_mastery, value)

    class ElementalDMG(
        private val vision: Vision? = null,
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

    companion object DatabaseMapper {
        fun getState(value: String): Stat? = when (value) {
            "LVL" -> Level()
            "ATK" -> ATK()
            "ATR" -> ATK_RATE()
            "DEF" -> DEF()
            "DER" -> DEF_RATE()
            "HP" -> HP()
            "HPR" -> HP_RATE()
            "EM" -> ElementalMastery()
            "EDB" -> ElementalDMG()
            "PDB" -> PhysDMG()
            "CR" -> CritRate()
            "CDM" -> CritDMG()
            "RCD" -> ReduceCD()
            "ER" -> EnergyRecharge()
            "HB" -> HealingBonus()
            "PS" -> PowerfulShield()
            else -> null
        }

        fun getStringId(value: Stat): String = when (value) {
            is Level -> "LVL"
            is ATK -> "ATK"
            is ATK_RATE -> "ATR"
            is DEF -> "DEF"
            is DEF_RATE -> "DER"
            is HP -> "HP"
            is HP_RATE -> "HPR"
            is ElementalMastery -> "EM"
            is ElementalDMG -> "EDB"
            is PhysDMG -> "PDB"
            is CritRate -> "CR"
            is CritDMG -> "CDM"
            is ReduceCD -> "RCD"
            is EnergyRecharge -> "ER"
            is HealingBonus -> "HB"
            is PowerfulShield -> "PS"
        }
    }
}