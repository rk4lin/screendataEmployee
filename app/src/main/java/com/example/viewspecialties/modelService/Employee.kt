package com.example.viewspecialties.modelService


data class Employee(
    val f_name: String,
    val l_name: String,
    val birthday: String?,
    val avatr_url: String? = null,
    val specialty: List<Specialty>
)



