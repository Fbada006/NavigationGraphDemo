package com.disruption.navigationgraphdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_welcome.view.*

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        //Set a listener on the register button to go to the registration form
        //Only navigate if the editTexts are not empty.
        //WARNING: This is for testing conditional navigation only
        view.findViewById<Button>(R.id.button_login).setOnClickListener {
            val email = view.editTextEmail.text.toString().trim()
            val password = view.editTextPassword.text.toString().trim()

            if (email.isNotEmpty() and password.isNotEmpty()) {
                findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
            } else {
                Snackbar.make(it, "Password and text cannot be empty!", Snackbar.LENGTH_LONG)
                    .show()
            }
        }

        view.findViewById<Button>(R.id.button_registration).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_registrationFragment)
        )

        return view
    }
}
