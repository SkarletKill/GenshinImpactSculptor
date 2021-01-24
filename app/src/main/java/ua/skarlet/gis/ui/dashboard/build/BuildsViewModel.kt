/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.build

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ua.skarlet.gis.db.build.Build
import ua.skarlet.gis.repo.BuildRepository
import ua.skarlet.gis.ui.BaseViewModel

class BuildsViewModel : BaseViewModel() {

    private val repo = BuildRepository(viewModelScope, db.buildDao())

    val builds: LiveData<List<Build>> = repo.getAll()

    fun removeItem(position: Int) {
        repo.delete(builds.value!![position])
    }
}