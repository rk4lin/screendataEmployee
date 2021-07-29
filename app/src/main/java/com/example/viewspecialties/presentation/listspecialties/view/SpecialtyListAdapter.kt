package com.example.viewspecialties.presentation.listspecialties.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewspecialties.R
import com.example.viewspecialties.modelService.Specialty


class SpecialtyListAdapter :  RecyclerView.Adapter<SpecialtyViewHolder>(){
    /*var employeeLocallist = mutableListOf<Employee>()*/
    var specialtyLocallist = mutableListOf<Specialty>()

    fun setDataSpecialty(items: List<Specialty>){

        specialtyLocallist.clear()
        specialtyLocallist.addAll(items)

        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtyViewHolder {
       return SpecialtyViewHolder(LayoutInflater.from(parent.context)
           .inflate(R.layout.cell_sepcialty, parent, false))
    }

    override fun onBindViewHolder(holder: SpecialtyViewHolder, position: Int) {

        holder.bind(specialtyLocallist[position])

    }

    override fun getItemCount(): Int {
        return specialtyLocallist.size
    }
}