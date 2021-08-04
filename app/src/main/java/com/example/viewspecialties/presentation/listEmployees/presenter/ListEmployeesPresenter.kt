package com.example.viewspecialties.presentation.listEmployees.presenter

import android.util.Log
import com.example.viewspecialties.BasePresenter
import com.example.viewspecialties.cacheRepository.CacheDataRepository
import com.example.viewspecialties.cacheRepository.CacheRepository
import com.example.viewspecialties.presentation.detailInfoEmployee.model.EmployeeLocal
import com.example.viewspecialties.presentation.listEmployees.view.IListEmployeeFragment
import com.example.viewspecialties.presentation.listspecialties.model.SpecialtyLocal
import com.google.android.material.datepicker.SingleDateSelector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListEmployeesPresenter : BasePresenter<IListEmployeeFragment>() {

    private var specialtyId: Int? = null

    override fun onAttach(view: IListEmployeeFragment) {
        super.onAttach(view)

        specialtyId = view.getSpecialtyId()
        getEmployee()
    }

    private fun getEmployee() {
        CoroutineScope(Dispatchers.Default).launch {
          var castToEmployeeClient =  CacheDataRepository.returnData()
            var specialty = mutableListOf<SpecialtyLocal>()
            var empl = mutableListOf<EmployeeLocal>()

          castToEmployeeClient.resp.forEach { e->
              specialty.addAll(e.specialty.map {
                  SpecialtyLocal(
                      it.specialty_id,
                      it.name
                  )
              })
          }

specialty = specialty.distinct().toMutableList()

            var mpc =  castToEmployeeClient.resp.forEach { e->if(
              e.specialty.any{it.specialty_id == specialtyId})
            {
                empl.add(
                    EmployeeLocal(
                    f_name = e.f_name.lowercase().capitalize(),
                    l_name = e.l_name.lowercase().capitalize(),
                    birthday = e.birthday ?: "нет даты рождения"
                ))
            }

            }

             /* var employees = CacheRepository.getEployees(specialtyId!!).await()

            println("сотрудники по спец ${employees}")
            if (employees != null) {
                var castToEmployeeClient = employees?.map {
                    EmployeeLocal(
                        f_name = it.f_name,
                        l_name = it.l_name,
                        birthday = it.birthday
                    )
                }?.toMutableList()*/

                withContext(Dispatchers.Main) {
                    view?.showEmployeeList(empl)
                }
            }
        }

    }
