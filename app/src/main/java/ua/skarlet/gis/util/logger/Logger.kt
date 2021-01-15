package ua.skarlet.gis.util.logger

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment
import java.lang.Exception

fun Activity.log(e: Exception) {
    log(this::class.simpleName ?: "GIS", e.message.toString())
}

fun Fragment.log(e: Exception) {
    log(this::class.simpleName ?: "GIS", e.message.toString())
}

fun log(tag: String, message: String) {
    Log.d(tag, message)
}