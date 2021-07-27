package com.example.viewspecialties.presentation.detailInfoEmployee.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewspecialties.R
import com.example.viewspecialties.presentation.listspecialties.model.Employee

class DetailListAdapter:  RecyclerView.Adapter<DetailViewHolder>() {

    var employeeLocalList = mutableListOf<Employee>()

    fun setDataEmployee(items: List<Employee>){

        employeeLocalList.clear()
        employeeLocalList.addAll(items)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_employee, parent, false))
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
       holder.bind(employeeLocalList[position])
    }

    override fun getItemCount(): Int {
        return employeeLocalList.size
    }

}