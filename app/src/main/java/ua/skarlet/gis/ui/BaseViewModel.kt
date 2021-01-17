/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ua.skarlet.gis.db.AppDatabase

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    val db get() = AppDatabase.getDB(getApplication())
}