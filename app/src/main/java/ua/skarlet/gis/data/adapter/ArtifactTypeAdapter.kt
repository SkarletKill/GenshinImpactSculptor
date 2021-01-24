/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.data.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skarlet.gis.R
import kotlinx.android.synthetic.main.item_view_element.view.*
import ua.skarlet.gis.data.enumeration.ArtifactType
import ua.skarlet.gis.util.ext.createView
import ua.skarlet.gis.util.ext.getString
import ua.skarlet.gis.util.font.makeBold
import ua.skarlet.gis.util.font.makeNormal
import ua.skarlet.gis.util.view.dropdown.DropdownTextInputAdapter
import ua.skarlet.gis.util.view.dropdown.ItemSelectedListener

class ArtifactTypeAdapter(
    focusListener: ItemSelectedListener
) : DropdownTextInputAdapter<ArtifactTypeAdapter.ViewHolder>(focusListener) {
    var items: List<ArtifactType> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(createView(parent, R.layout.item_view_element))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(items[position])
    }

    override fun getItemLabel(itemView: View): String = itemView.elementText.text.toString()

    private fun getItemLabel(artifactType: ArtifactType): String = getString(artifactType.stringRes)

    fun updateLabel(item: ArtifactType) = updateLabel(getItemLabel(item))

    override fun onItemSelected(itemView: View) {
        itemView.elementText.makeBold()
        itemView.elementText.setTextColor(itemView.resources.getColor(R.color.textPrimary, null))
    }

    override fun onCancelItemSelection(itemView: View) {
        itemView.elementText.makeNormal()
        itemView.elementText.setTextColor(itemView.resources.getColor(R.color.textSecondary, null))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ArtifactType) = itemView.run {
            elementText.text = resources.getString(item.stringRes)
            elementImage.setBackgroundResource(item.drawable)
        }
    }
}