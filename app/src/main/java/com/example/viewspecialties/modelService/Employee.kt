package com.example.viewspecialties.modelService


import com.google.gson.annotations.SerializedName



data class Employee(
    val f_name: String,
    val l_name: String,
    val birthday: String,
    val avatr_url: String? = null,
   val specialty: List<Specialty>
)

