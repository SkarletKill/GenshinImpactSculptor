/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.util.view

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.skarlet.gis.R
import kotlinx.android.synthetic.main.view_s_spinner.view.*
import ua.skarlet.gis.util.recycler.ReactiveAdapter
import ua.skarlet.gis.util.view.SSpinner.TextProvider

class SSpinner(context: Context, attrs: AttributeSet?) : RelativeLayout(context, attrs) {
    private val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.SSpinner)
    private var dialog: SInputDialog? = null
    private val dialogHeader: String

    /**
     * The text that is displayed on the spinner
     */
    var label: String
        get() = sSpinnerLabel.text.toString()
        set(value) {
            sSpinnerLabel.text = value
        }

    init {
        // Inflate and attach your child XML
        LayoutInflater.from(context).inflate(R.layout.view_s_spinner, this)

        // Set header for the spinner from attributes
        dialogHeader = typedArray.getString(R.styleable.SSpinner_header) ?: "Choose an item"

        // Create and show dialog with available items
        sSpinnerLabel.setOnClickListener {
            adapter?.let {
                dialog = SInputDialog(context, dialogHeader, it).apply {
                    show()
                }
            } ?: throw RuntimeException("Adapter not found!")
        }
    }

    /**
     * A small superstructure over a [RecyclerView.Adapter] required for this [SSpinner].
     */
    var adapter: ReactiveAdapter<out RecyclerView.ViewHolder>? = null
    set(value) {
        field = value.apply {
            // Sets the text representation of a selected item as the title
            val provider = TextProvider { string ->
                label = string
                dialog?.dismiss()
                dialog = null
            }
            this?.setProvider(provider)
        }
    }

    /**
     * The purpose of life of this interface is to deliver text of [dialog]'s selected item
     * to this [spinner][SSpinner].
     */
    fun interface TextProvider {
        fun provide(text: String)
    }
}