/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.build

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skarlet.gis.R
import ua.skarlet.gis.db.build.Build
import ua.skarlet.gis.util.ext.createView

class BuildsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<Build> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // TODO: create xml layout
        return BuildsViewHolder(createView(parent, R.layout.item_view_weapon_type))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BuildsViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    class BuildsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Build) {
            itemView.run {

            }
        }
    }
}