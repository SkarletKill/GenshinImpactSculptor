/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.util.view.dropdown

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.MainThread
import androidx.recyclerview.widget.RecyclerView

/**
 * A small superstructure over a [RecyclerView.Adapter] required for [DropdownTextInputLayout].
 *
 * Adapters provide a binding from an app-specific data set to views that are displayed within a RecyclerView.
 *
 * @param VH A class that extends ViewHolder that will be used by the adapter.
 */
abstract class DropdownTextInputAdapter<VH : RecyclerView.ViewHolder>(
    private val itemSelectionListener: ItemSelectedListener
) : RecyclerView.Adapter<VH>(), SelectableContainer {
    private var provider: DropdownTextInputLayout.LabelProvider? = null

    override var selectedPosition: Int? = null
        @MainThread
        set(value) {
            Handler(Looper.getMainLooper()).post {
                field?.let(::notifyItemChanged)
                field = value
                field?.let(::notifyItemChanged)
            }
        }

    @CallSuper
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener { view ->
            provider?.provide(getItemLabel(view))
            itemSelectionListener.onItemSelected(position)
        }
        checkSelection(holder.itemView, selectedPosition == position)
    }

    /**
     * Returns a string representation for an adapter item
     */
    abstract fun getItemLabel(itemView: View): String

    protected fun updateLabel(label: String) {
        provider?.provide(label)
    }

    private fun checkSelection(itemView: View, isSelected: Boolean) {
        if (itemView.isSelected == isSelected) return
        itemView.isSelected = isSelected
        if (isSelected) {
            onItemSelected(itemView)
        } else {
            onCancelItemSelection(itemView)
        }
    }

    /**
     * Internal. Using this method in client code have no impact
     */
    internal fun setLabelProvider(labelProvider: DropdownTextInputLayout.LabelProvider) {
        provider = labelProvider
    }
}