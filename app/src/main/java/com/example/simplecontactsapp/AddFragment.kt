package com.example.simplecontactsapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class AddFragment : Fragment(R.layout.fragment_add) {
    private val vm: PeopleViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etName = view.findViewById<EditText>(R.id.etName)
        val etPhone = view.findViewById<EditText>(R.id.etPhone)
        val btnSave = view.findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val phone = etPhone.text.toString().trim()

            if (name.isNotEmpty() && phone.isNotEmpty()) {
                vm.add(Person(name, phone))
                etName.text.clear()
                etPhone.text.clear()
            } else {
                Toast.makeText(requireContext(), "Please enter both name and phone", Toast.LENGTH_SHORT).show()
            }
        }
    }
}