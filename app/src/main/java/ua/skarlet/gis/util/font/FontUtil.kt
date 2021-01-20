/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.util.font

import android.graphics.Typeface
import android.widget.TextView

fun TextView.makeBold() {
    setTypeface(typeface, Typeface.BOLD)
}

fun TextView.makeNormal() {
    setTypeface(typeface, Typeface.NORMAL)
}