package com.example.segopecel2.ui

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.segopecel2.R
import com.example.segopecel2.model.Pecel


class PecelListAdapter(
    private val onItemClickListener: (Pecel) -> Unit
): ListAdapter<Pecel, PecelListAdapter.PecelViewHolder>(WORDS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PecelViewHolder {
       return PecelViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: PecelViewHolder, position: Int) {
        val pecel =getItem(position)
        holder.bind(pecel)
        holder.itemView.setOnClickListener {
            onItemClickListener(pecel)
        }
    }

    class PecelViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nametextView3)
        private val addressTextView: TextView = itemView.findViewById(R.id.addresstextview)
        private val sidedishTextView: TextView = itemView.findViewById(R.id.sidedishtextView4)
        private val drinkTextView: TextView = itemView.findViewById(R.id.drinktextView4)
        private val priceTextView: TextView = itemView.findViewById(R.id.pricetextView5)

        fun bind(pecel: Pecel?) {
            nameTextView.text = pecel?.name
            addressTextView.text = pecel?.address
            sidedishTextView.text = pecel?.sidedish
            drinkTextView.text = pecel?.drink
            priceTextView.text = pecel?.price

        }

        companion object {
            fun create(parent: ViewGroup): PecelListAdapter.PecelViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_pecel, parent,false)
                return PecelViewHolder(view)

            }
        }
    }

    companion object{
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Pecel>(){
            override fun areItemsTheSame(oldItem: Pecel, newItem: Pecel): Boolean {
               return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Pecel, newItem: Pecel): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
