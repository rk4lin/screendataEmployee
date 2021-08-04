package com.example.viewspecialties.presentation.listEmployees.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewspecialties.R
import com.example.viewspecialties.modelService.Employee
import com.example.viewspecialties.presentation.detailInfoEmployee.model.EmployeeLocal
import com.example.viewspecialties.presentation.listspecialties.view.OnItemClick
import java.text.SimpleDateFormat

class EmployeeListViewHolder(view: View, private val handler: OnEmployeeClick?) :
    RecyclerView.ViewHolder(view) {

    private var container: View = view.findViewById(R.id.conteiner_info_empl)
    private var f_name: TextView = view.findViewById(R.id.name_epml)
    private var l_name: TextView = view.findViewById(R.id.sourname_empl)
   // private var age: TextView = view.findViewById(R.id.age_empl)
    private var birthday: TextView = view.findViewById(R.id.age_empl)


    fun bind(employee: EmployeeLocal){
        f_name.text = employee.f_name
        l_name.text = employee.l_name
        birthday.text = SimpleDateFormat("dd.MM.yyyy").format(SimpleDateFormat("yyyy-MM-dd").parse(employee.birthday))
        //age.text = employee.f_name

        container.setOnClickListener{
            handler?.onClicked(name = employee.f_name, sourname = employee.l_name)
        }
    }
}