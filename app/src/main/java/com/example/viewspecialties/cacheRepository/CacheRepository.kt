package com.example.viewspecialties.cacheRepository

import android.util.Log
import com.example.viewspecialties.database.AppDatabase
import com.example.viewspecialties.presentation.listspecialties.model.Employee
import com.example.viewspecialties.presentation.listspecialties.model.ObjectResponse
import com.example.viewspecialties.presentation.listspecialties.model.Speciality
import kotlinx.coroutines.*
import java.lang.Exception

object CacheRepository {

    //эту штуку будем использовать в interactor дергать
    fun getData(): Deferred<ObjectResponse?> {
        return CoroutineScope(Dispatchers.IO).async {

            try {
                val db = AppDatabase.invoke()
                val objectResponse =db.cacheResponseDao().getData()

                if(objectResponse == null){
                    return@async null
                }else{
                    val data = ObjectResponse(
                        objectResponse.resp.map{ empl ->
                            Employee(
                                f_name = empl.f_name,
                                l_name = empl.l_name,
                                birthday = empl.birthday,
                                age = 26, // TODO тут нужно высчетать возраст относительно даты рождения
                                avatr_url = empl.avatr_url,
                                specialty = empl.specialty?.map{
                                    Speciality(
                                        it.speciality_id,
                                        it.name
                                    )//Specialty
                                }//map
                            )//Employee
                        }//map Employee
                    )//Objectresponse

                    return@async data
                }//else
            } catch (ex: Exception){

                return@async null
            }

        }
    }
  private fun getAge(birthday: String) : Int{
      return 11
  }

    fun insertData(data: ObjectResponse)=
        CoroutineScope(Dispatchers.IO).async {
            /*var employees = data.resp.map{e->
                CacheEmployeeEntity(
                    id =0,
                    f_name = e.f_name,
                    l_name = e.l_name,
                    birthday = e.birthday,
                    avatr_url = e.avatr_url,
                    specialty_key = 0

                )
            }

             data.resp.forEach{
                 var speciality=   it.specialty?.map{
                        CacheSpecialtyEntity(
                            key = 0,
                            specialty_id = it.speciality_id,
                            name = it.name
                        )
                    }
                 }*/

            try{
                val db = AppDatabase.invoke()
               db.cacheResponseDao().insertResponse(data)
                return@async true
            }catch (ex: Exception){
                Log.e("CachRespository_Insert", "Ошибка: ${ex.message}", ex)
                return@async false
            }
            }
}



