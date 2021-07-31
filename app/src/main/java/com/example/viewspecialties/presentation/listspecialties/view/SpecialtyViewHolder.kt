package com.example.viewspecialties.presentation.listspecialties.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewspecialties.R
import com.example.viewspecialties.modelService.Specialty


class SpecialtyViewHolder(view: View,private val  handler: OnItemClick?) : RecyclerView.ViewHolder(view) {

    private var id: TextView = view.findViewById(R.id.specialty_id)
    private var name: TextView = view.findViewById(R.id.specialty_name)

    fun bind(specialty: Specialty){
       id.text = specialty.specialty_id.toString()
       name.text = specialty.name

        name.setOnClickListener{
            handler?.onClicked(id = specialty.specialty_id)
        }
    }


}