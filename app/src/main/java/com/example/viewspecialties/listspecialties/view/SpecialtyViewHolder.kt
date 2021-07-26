package com.example.viewspecialties.listspecialties.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewspecialties.R
import com.example.viewspecialties.listspecialties.model.Employee
import com.example.viewspecialties.listspecialties.model.Speciality


class SpecialtyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var id: TextView = view.findViewById(R.id.specialty_id)
    var name: TextView = view.findViewById(R.id.specialty_name)


    fun bind(specialty: Speciality){
       id.text = specialty.speciality_id.toString()
       name.text = specialty.name
    }
}