package com.disruption.navigationgraphdemo.feed

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.disruption.navigationgraphdemo.R

class BoatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
    private val locationTextView = itemView.findViewById<TextView>(R.id.locationTextView)
    private val imageView = itemView.findViewById<ImageView>(R.id.imageView2)
    private val priceTextView = itemView.findViewById<TextView>(R.id.priceTextView)

    fun bind(boat: Boat, onBoatClick: (Int) -> Unit) {
        nameTextView.text = boat.name
        locationTextView.text = boat.location
        imageView.setImageResource(boat.picture)
        priceTextView.text = boat.price
        itemView.setOnClickListener { onBoatClick(boat.id) }
    }
}