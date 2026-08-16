package com.example.simplecontactsapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment(R.layout.fragment_list) {
    private val vm: PeopleViewModel by activityViewModels()
    private lateinit var adapter: PersonAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        adapter = PersonAdapter(emptyList(), requireContext())
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter

        vm.people.observe(viewLifecycleOwner) { people ->
            adapter = PersonAdapter(people, requireContext())
            recyclerView.adapter = adapter
        }
    }
}