package com.example.viewspecialties.listspecialties.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ObjectResponse(
    @SerializedName("response")
    val resp: List<Employee>
)

data class Employee(
    val f_name: String,
    val l_name: String,
    val birthday: String,
    val avatr_url: String? = null,
   val specialty: List<Speciality>? = null
)
