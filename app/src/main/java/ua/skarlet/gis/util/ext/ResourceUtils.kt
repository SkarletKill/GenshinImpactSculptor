/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.util.ext

import androidx.annotation.StringRes
import ua.skarlet.gis.GenshinImpactApplication

fun getString(@StringRes resId: Int): String =
    GenshinImpactApplication.application.resources.getString(resId)