/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.artifact

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skarlet.gis.R
import ua.skarlet.gis.db.artifact.Artifact
import ua.skarlet.gis.util.ext.createView

class ArtifactsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<Artifact> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // TODO: create xml layout
        return ArtifactsViewHolder(createView(parent, R.layout.item_view_weapon_type))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ArtifactsViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    class ArtifactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Artifact) {
            itemView.run {

            }
        }
    }
}