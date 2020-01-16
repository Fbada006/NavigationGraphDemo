package com.disruption.navigationgraphdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.disruption.navigationgraphdemo.feed.BOATS
import com.disruption.navigationgraphdemo.feed.getBoat
import kotlinx.android.synthetic.main.fragment_boat.view.*

class BoatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Use the ID from the deep link or from the safe args depending on where it comes from
        val id = arguments?.getString("id_dl")?.toInt() ?: BoatFragmentArgs.fromBundle(arguments!!).id

        val boat = BOATS.getBoat(id)

        val view = inflater.inflate(R.layout.fragment_boat, container, false)
        view.nameTextView.text = boat.name
        view.locationTextView.text = boat.location
        view.imageView2.setImageResource(boat.picture)
        view.priceTextView.text = boat.price
        return view
    }
}
