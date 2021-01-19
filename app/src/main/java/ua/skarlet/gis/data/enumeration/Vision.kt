/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.data.enumeration

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.skarlet.gis.R
import ua.skarlet.gis.util.ext.getString

enum class Vision(val uid: Int, @StringRes val stringRes: Int, @DrawableRes val drawable: Int) {
    PYRO(1, R.string.pyro, R.drawable.ic_element_pyro),
    HYDRO(2, R.string.hydro, R.drawable.ic_element_hydro),
    DENDRO(7, R.string.dendro, R.drawable.ic_element_dendro),
    ELECTRO(4, R.string.electro, R.drawable.ic_element_electro),
    ANEMO(5, R.string.anemo, R.drawable.ic_element_anemo),
    CRYO(3, R.string.cryo, R.drawable.ic_element_cryo),
    GEO(6, R.string.geo, R.drawable.ic_element_geo);

    companion object {
        fun byName(name: String) = values().find { name == getString(it.stringRes) }
    }
}