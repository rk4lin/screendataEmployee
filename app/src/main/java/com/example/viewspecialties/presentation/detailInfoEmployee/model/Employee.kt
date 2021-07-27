package com.example.viewspecialties.presentation.listspecialties.model

import com.google.gson.annotations.SerializedName

data class ObjectResponse(
    @SerializedName("response")
    val resp: List<Employee>
)

data class Employee(
    val f_name: String,
    val l_name: String,
    val age: Int,
    val birthday: String,
    val avatr_url: String? = null,
   val specialty: List<Speciality>? = null
)
