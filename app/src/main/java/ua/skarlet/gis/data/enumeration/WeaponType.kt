/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.data.enumeration

import androidx.annotation.StringRes
import com.skarlet.gis.R
import ua.skarlet.gis.util.ext.getString

enum class WeaponType(val uid: Int, @StringRes val stringRes: Int) {
    BOW(4, R.string.bow),
    SWORD(1, R.string.sword),
    POLEARM(3, R.string.polearm),
    CLAYMORE(2, R.string.claymore),
    CATALYST(5, R.string.catalyst);

    companion object {
        fun byName(name: String) = values().find { name == getString(it.stringRes) }
    }
}