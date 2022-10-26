package com.disruption.navigationgraphdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.disruption.navigationgraphdemo.feed.BOATS
import com.disruption.navigationgraphdemo.feed.getBoat

class BoatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Use the ID from the deep link or from the safe args depending on where it comes from
        val id = arguments?.getString("id_dl")?.toInt() ?: BoatFragmentArgs.fromBundle(requireArguments()).id

        val boat = BOATS.getBoat(id)

        val view = inflater.inflate(R.layout.fragment_boat, container, false)
        view.findViewById<TextView>(R.id.nameTextView).text = boat.name
        view.findViewById<TextView>(R.id.locationTextView).text = boat.location
        view.findViewById<ImageView>(R.id.imageView2).setImageResource(boat.picture)
        view.findViewById<TextView>(R.id.priceTextView).text = boat.price
        return view
    }
}
