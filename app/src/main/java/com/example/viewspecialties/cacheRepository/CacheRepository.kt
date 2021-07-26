package com.example.viewspecialties.cacheRepository

import android.app.Application
import android.util.Log
import androidx.annotation.WorkerThread
import com.example.viewspecialties.database.AppDatabase
import com.example.viewspecialties.database.dao.CacheResponseDao
import com.example.viewspecialties.database.entity.CacheEmployeeEntity
import com.example.viewspecialties.database.entity.CacheResponseEntity
import com.example.viewspecialties.database.entity.CacheSpecialtyEntity
import com.example.viewspecialties.listspecialties.model.ObjectResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

object CacheRepository{

// TODO сохранение в бд
    fun updateCacheAsync(data: ObjectResponse?) = CoroutineScope(Dispatchers.IO).async {
       /* var employees = data?.resp?.map { e ->
            CacheEmployeeEntity(
                1,
                e.f_name,
                e.l_name,
                e.birthday,
                e.avatr_url
            )
        }

        var specialty = data?.resp?.forEach { resp ->
            resp.specialty?.map { s ->
                CacheSpecialtyEntity(
                    1,
                    s.speciality_id,
                    s.name
                )
            }
        }
*/
        try {
            var db = AppDatabase.invoke()
            db.runInTransaction{
                db.cacheResponseDao().insertResponse(data!!)
            }
            return@async true
        } catch (ex: Exception) {
            Log.e("CacheRepository", "Ошибка: ${ex.message}", ex)
            return@async false
        }

    }
/*
    val allData: ObjectResponse = responseDao.getData()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(responseData: CacheResponseEntity){
        responseDao.insertResponse(responseData)}*/
}

