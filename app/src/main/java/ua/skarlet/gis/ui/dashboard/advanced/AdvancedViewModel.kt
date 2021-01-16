/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.advanced

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AdvancedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Advanced Fragment"
    }
    val text: LiveData<String> = _text
}