package com.example.viewspecialties.presentation.listEmployees.view

import com.example.viewspecialties.IBaseView
import com.example.viewspecialties.presentation.detailInfoEmployee.model.EmployeeLocal

interface IListEmployeeFragment : IBaseView{

    fun getSpecialtyId(): Int?
    fun showEmployeeList(employeeModel: MutableList<EmployeeLocal>)

}