/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.data

import ua.skarlet.gis.data.enumeration.Element

sealed class Stat(
    val name: String,
    open val value: Number
) {
    class ATK(
        override val value: Float
    ) : Stat("ATK", value)

    class DEF(
        override val value: Int
    ) : Stat("DEF", value)

    class HP(
        override val value: Int
    ) : Stat("HP", value)

    class CritRate(
        override val value: Float
    ) : Stat("CRIT Rate", value)

    class CritDMG(
        override val value: Float
    ) : Stat("CRIT DMG", value)

    class ElementalMastery(
        override val value: Float
    ) : Stat("Elemental Mastery", value)

    class ElementalDMG(
        private val element: Element,
        override val value: Float
    ) : Stat("${element.title} DMG Bonus", value)
}