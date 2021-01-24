/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.artifact

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ua.skarlet.gis.db.artifact.Artifact
import ua.skarlet.gis.repo.ArtifactRepository
import ua.skarlet.gis.ui.BaseViewModel

class ArtifactsViewModel : BaseViewModel() {

    private val repo = ArtifactRepository(viewModelScope, db.artifactDao())

    val artifacts: LiveData<List<Artifact>> = repo.getAll()

    fun removeItem(position: Int) {
        repo.delete(artifacts.value!![position])
    }
}