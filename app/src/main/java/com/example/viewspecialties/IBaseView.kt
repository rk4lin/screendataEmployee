package com.example.viewspecialties

import com.example.viewspecialties.modelService.Specialty

interface IBaseView {

}

interface ISpecialtyView : IBaseView{

    fun getDataSpecialty(data: MutableList<Specialty>)

}