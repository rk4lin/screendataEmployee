package com.example.viewspecialties.presentation.listspecialties.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewspecialties.R
import com.example.viewspecialties.modelService.Specialty


class SpecialtyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var id: TextView = view.findViewById(R.id.specialty_id)
    var name: TextView = view.findViewById(R.id.specialty_name)


    fun bind(specialty: Specialty){
       id.text = specialty.specialty_id.toString()
       name.text = specialty.name
    }
}