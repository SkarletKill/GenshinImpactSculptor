/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.build

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BuildsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Builds Fragment"
    }
    val text: LiveData<String> = _text
}