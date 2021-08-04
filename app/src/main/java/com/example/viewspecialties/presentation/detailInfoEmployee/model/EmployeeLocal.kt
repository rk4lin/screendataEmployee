package com.example.viewspecialties.presentation.detailInfoEmployee.model

import com.example.viewspecialties.presentation.listspecialties.model.SpecialtyLocal

data class EmployeeLocal(
    val f_name: String,
    val l_name: String,
    val birthday: String,
    var age: Int? = null

)

data class EmployeeDetail(
    val f_name: String,
    val l_name: String,
    val ava_url: String? = null,
    val age: String?,
    val birthday: String,
    val specialty: String

)
