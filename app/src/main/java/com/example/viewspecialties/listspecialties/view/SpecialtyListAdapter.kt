package com.example.viewspecialties.listspecialties.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewspecialties.R
import com.example.viewspecialties.listspecialties.model.Employee
import com.example.viewspecialties.listspecialties.model.Speciality


class SpecialtyListAdapter :  RecyclerView.Adapter<SpecialtyViewHolder>(){
    /*var employeeLocallist = mutableListOf<Employee>()*/
    var specialtyLocallist = mutableListOf<Speciality>()

    fun setDataSpecialty(items: List<Speciality>){

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