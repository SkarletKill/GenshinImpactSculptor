/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.util.view.dropdown

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.EditText
import android.widget.FrameLayout
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.skarlet.gis.R
import ua.skarlet.gis.util.ext.getString
import ua.skarlet.gis.util.view.dropdown.DropdownTextInputLayout.LabelProvider

class DropdownTextInputLayout(context: Context, attrs: AttributeSet?) : TextInputLayout(context, attrs) {
    private val typedArray: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.DropdownTextInputLayout)
    private var dialog: DropdownTextInputDialog? = null
    private val dialogHeader: String

    private val editText: TextInputEditText
        get() = (children.first() as FrameLayout).children.find { it is EditText } as TextInputEditText

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        editText.isFocusable = false
        editText.isCursorVisible = false

        // Create and show dialog with available items
        editText.setOnClickListener {
            adapter?.let {
                dialog = DropdownTextInputDialog(context, dialogHeader, it).apply {
                    show()
                }
            } ?: throw RuntimeException("Adapter not found!")
        }
    }

    init {
        // Set header for the spinner from attributes
        dialogHeader = typedArray.getString(R.styleable.DropdownTextInputLayout_dropdownHeader)
            ?: getString(R.string.choose_an_item)
    }

    /**
     * A small superstructure over a [RecyclerView.Adapter] required for this [DropdownTextInputLayout].
     */
    var adapter: DropdownTextInputAdapter<out RecyclerView.ViewHolder>? = null
        set(value) {
            field = value.also { adapter ->
                // Sets the text representation of a selected item as the title
                val provider = LabelProvider { label ->
                    editText.setText(label)
                    dialog?.dismiss()
                    dialog = null
                }
                adapter?.setLabelProvider(provider)
            }
        }

    /**
     * The purpose of life of this interface is to deliver text of [dialog]'s selected item
     * to this [spinner][DropdownTextInputLayout].
     */
    fun interface LabelProvider {
        fun provide(label: String)
    }
}