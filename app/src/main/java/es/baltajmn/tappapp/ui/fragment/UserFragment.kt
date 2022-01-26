package es.baltajmn.tappapp.ui.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import es.baltajmn.tappapp.R
import es.baltajmn.tappapp.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding
    private lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentUserBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = activity?.getSharedPreferences(
            getString(R.string.shared_preferences), Context.MODE_PRIVATE
        ) as SharedPreferences
    }

    override fun onPause() {
        super.onPause()
        saveUsersSelected()
    }

    private fun saveUsersSelected() {
        if (binding.chip1.isChecked) {
            with(sharedPref.edit()) {
                putBoolean("albala", true)
                commit()
            }
        }

        if (binding.chip2.isChecked) {
            with(sharedPref.edit()) {
                putBoolean("angel", true)
                commit()
            }
        }

        if (binding.chip3.isChecked) {
            with(sharedPref.edit()) {
                putBoolean("anto", true)
                commit()
            }
        }

        if (binding.chip4.isChecked) {
            with(sharedPref.edit()) {
                putBoolean("balta", true)
                commit()
            }
        }

        if (binding.chip5.isChecked) {
            with(sharedPref.edit()) {
                putBoolean("churre", true)
                commit()
            }
        }

        if (binding.chip6.isChecked) {
            with(sharedPref.edit()) {
                putBoolean("ciscu", true)
                commit()
            }
        }

        if (binding.chip7.isChecked) {
            with(sharedPref.edit()) {
                putBoolean("martinez", true)
                commit()
            }
        }

        if (binding.chip8.isChecked) {
            with(sharedPref.edit()) {
                putBoolean("rati", true)
                commit()
            }
        }

        if (binding.chip9.isChecked) {
            with(sharedPref.edit()) {
                putBoolean("otro", true)
                commit()
            }
        }
    }
}