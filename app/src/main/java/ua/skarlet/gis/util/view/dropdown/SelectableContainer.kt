/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.util.view.dropdown

import android.view.View

interface SelectableContainer {
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