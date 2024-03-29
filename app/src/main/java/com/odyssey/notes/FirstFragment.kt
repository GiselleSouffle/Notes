package com.odyssey.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val second = view.findViewById<Button>(R.id.second_button)

        second.setOnClickListener {
            val controller : NavController =
                Navigation.findNavController(view)
            controller.navigate(
                R.id.action_firstFragment_to_listFragment)
        }


        return view
    }
}