/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.data.enumeration

import androidx.annotation.StringRes
import com.skarlet.gis.R
import ua.skarlet.gis.util.ext.getString

enum class Element(val uid: Int, @StringRes val stringRes: Int) {
    PYRO(1, R.string.pyro),
    HYDRO(2, R.string.hydro),
    DENDRO(7, R.string.dendro),
    ELECTRO(4, R.string.electro),
    ANEMO(5, R.string.anemo),
    CRYO(3, R.string.cryo),
    GEO(6, R.string.geo);

    companion object {
        fun byName(name: String) = values().find { name == getString(it.stringRes) }
    }
}