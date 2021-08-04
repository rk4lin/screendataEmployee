package com.example.viewspecialties.cacheRepository

import android.util.Log
import com.example.viewspecialties.database.AppDatabase
import com.example.viewspecialties.database.entity.CacheEmployeeEntity
import com.example.viewspecialties.database.entity.CacheSpecialtyEntity
import com.example.viewspecialties.modelService.Employee
import com.example.viewspecialties.modelService.ObjectResponse
import com.example.viewspecialties.modelService.Specialty
import com.example.viewspecialties.presentation.detailInfoEmployee.model.EmployeeLocal
import com.example.viewspecialties.presentation.listspecialties.model.SpecialtyLocal
import kotlinx.coroutines.*
import java.lang.Exception

object CacheRepository {
private var specialty: MutableList<CacheSpecialtyEntity>? = null
/*   fun getEployees(specialtyId: Int): Deferred<List<CacheEmployeeEntity>?> {
        return CoroutineScope(Dispatchers.IO).async {

            try {
                val db = AppDatabase.invoke()
                val employees =db.cacheEmployeeDao().getById(specialtyId)
                println("cacheRepository запрос в базу $employees")
                if(employees == null){
                    return@async null
                }else{
                  *//*  val data = ObjectResponse(
                        objectResponse.resp.map{ empl ->
                            Employee(
                                f_name = empl.f_name,
                                l_name = empl.l_name,
                                birthday = empl.birthday,
                                 // TODO тут нужно высчетать возраст относительно даты рождения
                                avatr_url = empl.avatr_url,
                                specialty = empl.specialty?.map{
                                    Specialty(
                                        it.specialty_id,
                                        it.name
                                    )//Specialty
                                }//map
                            )//Employee
                        }//map Employee
                    )//Objectresponse*//*

                    return@async employees
                }//else
            } catch (ex: Exception){

                return@async null
            }

        }
    }*/

    fun insertData(data: ObjectResponse)=
        CoroutineScope(Dispatchers.IO).async {

            var employees = data.resp.map{e->
                CacheEmployeeEntity(

                    f_name = e.f_name,
                    l_name = e.l_name,
                    birthday = e.birthday?: "-",
                    avatr_url = e.avatr_url,
                    specId = 0,
                )
            }
            data.resp.forEach { empl->
                empl.specialty.map{
                    var spec = CacheSpecialtyEntity(
                        specialty_id = it.specialty_id,
                        name = it.name
                    )
                    specialty?.add(spec)
                }
            }
            specialty = specialty?.distinct()?.toMutableList()

            try{
                val db = AppDatabase.invoke()

                db.cacheEmployeeDao().deleteAllEmployee()
                db.cacheEmployeeDao().insertEmployee(employees)
                db.cacheSpecialtyDao().deleteAllSpecialty()
                db.cacheSpecialtyDao().insertSpecialty(specialty!!)
                //db.cacheSpecialtyDao().insertSpecialty(specialty)
                return@async true
            }catch (ex: Exception){
                Log.e("CachRespository_Insert", "Ошибка: ${ex.message}", ex)
                return@async false
            }
            }



}



