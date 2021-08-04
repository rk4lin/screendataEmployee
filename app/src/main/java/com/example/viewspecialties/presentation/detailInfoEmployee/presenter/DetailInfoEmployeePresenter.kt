package com.example.viewspecialties.presentation.detailInfoEmployee.presenter

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.viewspecialties.BasePresenter

import com.example.viewspecialties.cacheRepository.CacheDataRepository

import com.example.viewspecialties.modelService.Employee
import com.example.viewspecialties.modelService.ObjectResponse
import com.example.viewspecialties.modelService.Specialty
import com.example.viewspecialties.presentation.detailInfoEmployee.model.EmployeeDetail
import com.example.viewspecialties.presentation.detailInfoEmployee.view.IDetailFragment
import kotlinx.coroutines.*
import org.joda.time.Years
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Year
import java.time.format.DateTimeFormatter
import java.util.*

class DetailInfoEmployeePresenter : BasePresenter<IDetailFragment>() {

    private var detailInfo: EmployeeDetail? = null

    override fun onAttach(view: IDetailFragment) {
        super.onAttach(view)
        var data = CacheDataRepository.returnData()
        detailInfo = getSpecialtyModel(data)
    }

    fun getDetailInfo(): EmployeeDetail? {
        if(detailInfo != null){
         return detailInfo
        }
        else{
            return null
        }
    }


     private fun getSpecialtyModel(data: ObjectResponse) : EmployeeDetail?{

        var name = view?.getTriple()?.first
        var sourname = view?.getTriple()?.second
         var specialty = view?.getTriple()?.third

        data.resp.filter { e ->
            e.f_name.lowercase().capitalize() == name && e.l_name.lowercase().capitalize() == sourname
        }.map {
            return EmployeeDetail(
                it.f_name.lowercase().capitalize(),
                it.l_name.lowercase().capitalize(),
                it.avatr_url,
                age = getAgeEmployee(it.birthday!!),
                birthday = it.birthday,
                specialty = specialty!!

            )
        }
         return null
    }


    private fun getAgeEmployee(date: String): String{

        var age = Years.yearsBetween(org.joda.time.LocalDate.parse(date), org.joda.time.LocalDate.now())
         return age.years.toString()


    }

}