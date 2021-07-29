package com.example.viewspecialties.presentation.listspecialties.presenter

import com.example.viewspecialties.BasePresenter
import com.example.viewspecialties.cacheRepository.CacheDataRepository
import com.example.viewspecialties.modelService.ObjectResponse
import com.example.viewspecialties.modelService.Specialty
import com.example.viewspecialties.presentation.listspecialties.view.ListSpecialtiesFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListSpecialtiesPresenter : BasePresenter<ListSpecialtiesFragment>() {

    override fun onAttach(view: ListSpecialtiesFragment) {
        super.onAttach(view)
         getData()
    }

    fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            var responseData = CacheDataRepository.requestData().await()
            if (responseData != null) {
               withContext(Dispatchers.Main){
                getSpecialtyModel(responseData)}
            }
        }
    }

    private fun getSpecialtyModel(data: ObjectResponse) {
        var specialty = mutableListOf<Specialty>()

        data?.resp.forEach { resp ->
            resp.specialty?.map { spec ->
                specialty.add(
                    Specialty(
                        specialty_id = spec.specialty_id,
                        name = spec.name
                    )
                )

            }
        }

            view?.getDataSpecialty(specialty)

    }


}