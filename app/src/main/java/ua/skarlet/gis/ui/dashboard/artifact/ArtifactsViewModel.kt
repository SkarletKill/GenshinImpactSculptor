/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.artifact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArtifactsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Artifacts Fragment"
    }
    val text: LiveData<String> = _text
}