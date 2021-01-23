/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.character.one

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skarlet.gis.R
import kotlinx.android.synthetic.main.item_view_element.view.*
import ua.skarlet.gis.data.enumeration.Vision
import ua.skarlet.gis.util.ext.createView
import ua.skarlet.gis.util.ext.getString
import ua.skarlet.gis.util.font.makeBold
import ua.skarlet.gis.util.font.makeNormal
import ua.skarlet.gis.util.view.dropdown.DropdownTextInputAdapter
import ua.skarlet.gis.util.view.dropdown.ItemSelectedListener

class VisionAdapter(
    focusListener: ItemSelectedListener
) : DropdownTextInputAdapter<VisionAdapter.ViewHolder>(focusListener) {
    var items: List<Vision> = mutableListOf()
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

    private fun getItemLabel(vision: Vision): String = getString(vision.stringRes)

    fun updateLabel(item: Vision) = updateLabel(getItemLabel(item))

    override fun onItemSelected(itemView: View) {
        itemView.elementText.makeBold()
        itemView.elementText.setTextColor(itemView.resources.getColor(R.color.textPrimary, null))
    }

    override fun onCancelItemSelection(itemView: View) {
        itemView.elementText.makeNormal()
        itemView.elementText.setTextColor(itemView.resources.getColor(R.color.textSecondary, null))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Vision) = itemView.run {
            elementText.text = resources.getString(item.stringRes)
            elementImage.setBackgroundResource(item.drawable)
        }
    }
}