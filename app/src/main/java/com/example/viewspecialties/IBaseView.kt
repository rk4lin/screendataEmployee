package com.example.viewspecialties

import com.example.viewspecialties.modelService.Specialty

interface IBaseView {
    fun getDataSpecialty(data: MutableList<Specialty>)
}