/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.weapon

import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.skarlet.gis.R
import kotlinx.android.synthetic.main.item_view_weapon_type.view.*
import ua.skarlet.gis.db.weapon.Weapon
import ua.skarlet.gis.util.ext.createView

class WeaponsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<Weapon> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WeaponsViewHolder(createView(parent, R.layout.item_view_weapon_type))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is WeaponsViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    class WeaponsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Weapon) {
            itemView.run {
                weaponImage.setImageDrawable(ResourcesCompat.getDrawable(resources, item.type.drawable, null))
                weaponName.text = item.name
                weaponLvl.text = resources.getString(R.string.lvl_num, item.level)
            }
        }
    }
}