package com.example.simplecontactsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(
    private val people: List<Person>,
    private val context: Context
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textName: TextView = view.findViewById(R.id.textName)
        val textPhone: TextView = view.findViewById(R.id.textPhone)
        val btnCall: Button = view.findViewById(R.id.btnCall)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = people[position]
        holder.textName.text = person.name
        holder.textPhone.text = person.phone

        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                "Selected ${person.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        holder.btnCall.setOnClickListener {
            Toast.makeText(
                context,
                "Calling ${person.name} (${person.phone})",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int = people.size
}