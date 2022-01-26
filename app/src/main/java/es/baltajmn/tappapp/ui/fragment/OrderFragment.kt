package es.baltajmn.tappapp.ui.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import es.baltajmn.tappapp.R
import es.baltajmn.tappapp.databinding.FragmentOrderBinding
import es.baltajmn.tappapp.model.Order
import es.baltajmn.tappapp.model.User

class OrderFragment : Fragment() {

    private lateinit var binding: FragmentOrderBinding
    private lateinit var sharedPref: SharedPreferences

    private var defaultOrder: ArrayList<Order> = ArrayList()
    private var users: ArrayList<User> = ArrayList()
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentOrderBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = activity?.getSharedPreferences(
            getString(R.string.shared_preferences), Context.MODE_PRIVATE
        ) as SharedPreferences

        binding.recyclerOrder.layoutManager = LinearLayoutManager(context)
        userAdapter = UserAdapter(users)
        binding.recyclerOrder.adapter = userAdapter
    }

    override fun onResume() {
        super.onResume()
        getUsersSelected()
    }

    private fun getUsersSelected() {
        users.clear()

        if (sharedPref.getBoolean("albala", false)) {
            users.add(User("Albalá", defaultOrder))
        }

        if (sharedPref.getBoolean("angel", false)) {
            users.add(User("Ángel", defaultOrder))
        }

        if (sharedPref.getBoolean("anto", false)) {
            users.add(User("Anto", defaultOrder))
        }

        if (sharedPref.getBoolean("balta", false)) {
            users.add(User("Balta", defaultOrder))
        }

        if (sharedPref.getBoolean("churre", false)) {
            users.add(User("Churre", defaultOrder))
        }

        if (sharedPref.getBoolean("ciscu", false)) {
            users.add(User("Ciscu", defaultOrder))
        }

        if (sharedPref.getBoolean("martinez", false)) {
            users.add(User("Martinez", defaultOrder))
        }

        if (sharedPref.getBoolean("rati", false)) {
            users.add(User("Rati", defaultOrder))
        }

        if (sharedPref.getBoolean("otro", false)) {
            users.add(User("Otro", defaultOrder))
        }

        userAdapter.notifyDataSetChanged()
    }

}