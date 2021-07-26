package com.example.viewspecialties.detailInfoEmployee.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewspecialties.R
import com.example.viewspecialties.listspecialties.model.Employee
import com.example.viewspecialties.listspecialties.model.Speciality

class DetailViewHolder(view: View): RecyclerView.ViewHolder(view) {

    var f_name: TextView = view.findViewById(R.id.name)
    var l_name: TextView = view.findViewById(R.id.sourname)
    var birthday: TextView = view.findViewById(R.id.birthday)
    var age: TextView = view.findViewById(R.id.age)
    var ava: TextView = view.findViewById(R.id.avaUrl)



    fun bind(employee: Employee){
        f_name.text = employee.f_name
        l_name.text = employee.l_name
        birthday.text = employee.birthday
      //  age.text = employee.
        ava.text = employee.avatr_url

    }
}