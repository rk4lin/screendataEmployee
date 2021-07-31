package com.example.viewspecialties.presentation.listEmployees.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewspecialties.R
import com.example.viewspecialties.modelService.Employee
import com.example.viewspecialties.presentation.detailInfoEmployee.model.EmployeeLocal
import com.example.viewspecialties.presentation.listspecialties.view.OnItemClick

interface OnEmployeeClick{
    fun onClicked(name: String)
}

class EmployeeListAdapter : RecyclerView.Adapter<EmployeeListViewHolder>() {

    private var employeeData: MutableList<EmployeeLocal> = mutableListOf()

    private var clickHandler: OnEmployeeClick? = null

    fun initClick(handler: OnEmployeeClick) {
        clickHandler = handler
    }

    fun setData(empl: MutableList<EmployeeLocal>){
        employeeData.clear()
        employeeData.addAll(empl)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeListViewHolder {
       return EmployeeListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell_empl, parent, false), clickHandler)
    }

    override fun onBindViewHolder(holder: EmployeeListViewHolder, position: Int) {
        holder.bind(employeeData[position])
    }

    override fun getItemCount(): Int {
        return employeeData.size
    }
}