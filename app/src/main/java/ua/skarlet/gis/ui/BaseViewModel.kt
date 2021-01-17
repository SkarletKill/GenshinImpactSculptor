/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui

import androidx.lifecycle.ViewModel
import ua.skarlet.gis.GenshinImpactApplication
import ua.skarlet.gis.db.AppDatabase

abstract class BaseViewModel : ViewModel() {
    val db get() = AppDatabase.getDB(GenshinImpactApplication.application)
}