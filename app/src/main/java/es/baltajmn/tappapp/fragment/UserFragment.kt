package es.baltajmn.tappapp.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import es.baltajmn.tappapp.R
import es.baltajmn.tappapp.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding

    val sharedPref = activity?.getSharedPreferences(
        getString(R.string.shared_preferences), Context.MODE_PRIVATE
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentUserBinding.inflate(inflater)
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        saveUsersSelected()
    }

    private fun saveUsersSelected() {
        if (sharedPref != null) {
            if (binding.chip1.isChecked) {
                with(sharedPref.edit()) {
                    putBoolean("albala", true)
                    commit()
                }
            }

            if (binding.chip1.isChecked) {
                with(sharedPref.edit()) {
                    putBoolean("angel", true)
                    commit()
                }
            }

            if (binding.chip1.isChecked) {
                with(sharedPref.edit()) {
                    putBoolean("anto", true)
                    commit()
                }
            }

            if (binding.chip1.isChecked) {
                with(sharedPref.edit()) {
                    putBoolean("balta", true)
                    commit()
                }
            }

            if (binding.chip1.isChecked) {
                with(sharedPref.edit()) {
                    putBoolean("churre", true)
                    commit()
                }
            }

            if (binding.chip1.isChecked) {
                with(sharedPref.edit()) {
                    putBoolean("ciscu", true)
                    commit()
                }
            }

            if (binding.chip1.isChecked) {
                with(sharedPref.edit()) {
                    putBoolean("martinez", true)
                    commit()
                }
            }

            if (binding.chip1.isChecked) {
                with(sharedPref.edit()) {
                    putBoolean("rati", true)
                    commit()
                }
            }

            if (binding.chip1.isChecked) {
                with(sharedPref.edit()) {
                    putBoolean("otro", true)
                    commit()
                }
            }
        }
    }
}