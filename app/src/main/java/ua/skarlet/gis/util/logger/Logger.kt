/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.util.logger

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment

class Log(tag: String?) {
    constructor(context: Activity) : this(context::class.simpleName)
    constructor(context: Fragment) : this(context::class.simpleName)

    private val tag = tag ?: APP_TAG

    fun v(message: String) = verbose(tag, message)
    fun d(message: String) = debug(tag, message)
    fun i(message: String) = info(tag, message)
    fun w(message: String) = warning(tag, message)
    fun e(message: String) = error(tag, message)

    private fun verbose(tag: String, message: String) = Log.v(tag, message)
    private fun debug(tag: String, message: String) = Log.d(tag, message)
    private fun info(tag: String, message: String) = Log.i(tag, message)
    private fun warning(tag: String, message: String) = Log.w(tag, message)
    private fun error(tag: String, message: String) = Log.e(tag, message)

    companion object {
        private const val APP_TAG = "GIS"
    }
}