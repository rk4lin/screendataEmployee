package com.example.viewspecialties.presentation.detailInfoEmployee.view

import com.example.viewspecialties.IBaseView
import com.example.viewspecialties.presentation.detailInfoEmployee.model.EmployeeDetail

interface IDetailFragment : IBaseView {

    fun getTriple(): Triple<String?, String?, String?>
    fun updateView(emplDetal: EmployeeDetail)
}