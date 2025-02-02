/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.data.enumeration

import androidx.annotation.StringRes
import com.skarlet.gis.R
import ua.skarlet.gis.util.ext.getString

enum class ArtifactType(val uid: Int, @StringRes val stringRes: Int) {
    FLOWER(1, R.string.flower_of_life),
    PLUME(2, R.string.plume_of_death),
    SANDS(3, R.string.sands_of_eon),
    GOBLET(4, R.string.goblet_of_eonothem),
    CIRCLET(5, R.string.circlet_of_logos);

    companion object {
        fun byName(name: String) = values().find { name == getString(it.stringRes) }
    }
}