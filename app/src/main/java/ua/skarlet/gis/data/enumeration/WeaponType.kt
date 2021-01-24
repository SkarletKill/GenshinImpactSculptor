/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.data.enumeration

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.skarlet.gis.R
import ua.skarlet.gis.util.ext.getString

enum class WeaponType(val uid: Int, @StringRes val stringRes: Int, @DrawableRes val drawable: Int) {
    BOW(4, R.string.bow, R.drawable.ic_prototype_bow),
    SWORD(1, R.string.sword, R.drawable.ic_prototype_sword),
    POLEARM(3, R.string.polearm, R.drawable.ic_prototype_pole),
    CLAYMORE(2, R.string.claymore, R.drawable.ic_prototype_claymore),
    CATALYST(5, R.string.catalyst, R.drawable.ic_prototype_catalyst);

    companion object {
        fun byID(uid: Int) = values().find { uid == it.uid }
        fun byName(name: String) = values().find { name == getString(it.stringRes) }
    }
}