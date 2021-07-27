package com.example.viewspecialties.presentation.listspecialties.presenter

import com.example.viewspecialties.BasePresenter
import com.example.viewspecialties.cacheRepository.CacheDataRepository
import com.example.viewspecialties.presentation.listspecialties.model.ObjectResponse
import com.example.viewspecialties.presentation.listspecialties.model.Speciality
import com.example.viewspecialties.presentation.listspecialties.view.ListSpecialtiesFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListSpecialtiesPresenter : BasePresenter<ListSpecialtiesFragment>() {

    override fun onAttach(view: ListSpecialtiesFragment) {
        super.onAttach(view)
        getData()
    }

    private fun getData(){
        CoroutineScope(Dispatchers.IO).launch {
          var responseData = CacheDataRepository.getDataEmployeesService().await()
            getSpecialtyModel(responseData)
        }
    }

    private fun getSpecialtyModel(data: ObjectResponse){

        var speciality = mutableListOf<Speciality>()

        data?.resp.forEach{resp->
            resp.specialty.map{spec->
             speciality.add(Speciality(
                    speciality_id = spec.speciality_id,
                    name = spec.name
                )
             )
            }
        }

      view?.getDataSpecialty(speciality)
    }


}