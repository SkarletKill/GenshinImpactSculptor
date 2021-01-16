/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.weapon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeaponsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Weapons Fragment"
    }
    val text: LiveData<String> = _text
}