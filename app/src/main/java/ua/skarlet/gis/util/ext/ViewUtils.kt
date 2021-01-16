/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.util.ext

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * This function is designed to create a view using [layoutId] as unique identifier.
 * The function always returns the created View
 */
fun createView(parent: ViewGroup, @LayoutRes layoutId: Int, attachToRoot: Boolean = false): View {
    val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
    if (attachToRoot) parent.addView(view)
    return view
}