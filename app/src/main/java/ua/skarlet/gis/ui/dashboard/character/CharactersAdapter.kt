/*
 * Copyright (c) 2021 by Skarlet RED
 */

package ua.skarlet.gis.ui.dashboard.character

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skarlet.gis.R
import kotlinx.android.synthetic.main.item_view_character.view.*
import ua.skarlet.gis.db.character.Character
import ua.skarlet.gis.util.ext.createView

class CharactersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<Character> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CharactersViewHolder(createView(parent, R.layout.item_view_character))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharactersViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    class CharactersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Character) {
            itemView.run {
                characterName.text = item.name
                characterLvl.text = resources.getString(R.string.lvl_num, item.level)
            }
        }
    }
}