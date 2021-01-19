/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.util.recycler

import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.MainThread
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ua.skarlet.gis.util.view.SSpinner

/**
 * A small superstructure over a [RecyclerView.Adapter] required for [SSpinner].
 *
 * Adapters provide a binding from an app-specific data set to views that are displayed within a RecyclerView.
 *
 * @param VH A class that extends ViewHolder that will be used by the adapter.
 */
abstract class ReactiveAdapter<VH : RecyclerView.ViewHolder>(
    private val focusListener: ItemSelectedListener
) : RecyclerView.Adapter<VH>(), SelectableItem {
    @SuppressWarnings("LateinitUsage")
    private var provider: SSpinner.TextProvider? = null

    override var selectedPosition: Int? = null
        @SuppressWarnings("GlobalCoroutineUsage")
        @MainThread
        set(value) {
            // TODO: remove GlobalScope
            GlobalScope.launch(Dispatchers.Main) {
                field?.let(::notifyItemChanged)
                field = value
                field?.let(::notifyItemChanged)
            }
        }

    @CallSuper
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener { view ->
            provider?.provide(getItemLabel(view))
            focusListener.onSelect(position)
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
    internal fun setProvider(textProvider: SSpinner.TextProvider) {
        provider = textProvider
    }
}

interface SelectableItem {
    var selectedPosition: Int?

    /**
     * This method will be called when item is selected
     */
    fun onItemSelected(itemView: View)

    /**
     * This method will be called when the item loses its selection
     */
    fun onCancelItemSelection(itemView: View)
}