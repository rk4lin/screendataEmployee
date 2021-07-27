package com.example.viewspecialties.presentation.detailInfoEmployee.presenter

import com.example.viewspecialties.BasePresenter
import com.example.viewspecialties.cacheRepository.CacheDataRepository
import com.example.viewspecialties.presentation.detailInfoEmployee.view.DetailFragment
import com.example.viewspecialties.presentation.listspecialties.model.Employee
import com.example.viewspecialties.presentation.listspecialties.model.ObjectResponse
import com.example.viewspecialties.presentation.listspecialties.model.Speciality
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailInfoEmployeePresenter : BasePresenter<DetailFragment>() {

     override fun onAttach(view: DetailFragment) {
        super.onAttach(view)
        getDataDetailEmployee()
    }

    private fun getDataDetailEmployee() {
        CoroutineScope(Dispatchers.IO).launch {
            var responseData = CacheDataRepository.requestData().await()
            getSpecialtyModel(responseData!!)
        }
    }

    private fun getSpecialtyModel(data: ObjectResponse)  {

        var employees = mutableListOf<Employee>()
        var specialty = mutableListOf<Speciality>()

       data.resp.forEach {
          specialty.addAll( it.specialty!!.map{
               Speciality(
                   it.speciality_id,
                   it.name
               )
           })
        }


        data.resp.map { resp ->
            employees.add(
                Employee(
                    f_name = resp.f_name,
                    l_name = resp.l_name,
                    birthday = resp.birthday,
                    avatr_url = if (!resp.avatr_url.isNullOrBlank()) resp.avatr_url else "",
                    specialty = specialty,
                    age = resp.age
                )
            )
        }

        view?.getDataDetailEmployee(employees)
    }

    fun refresh(){
        getDataDetailEmployee()
    }

}