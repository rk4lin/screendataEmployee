package com.example.viewspecialties.cacheRepository

import android.util.Log
import com.example.viewspecialties.initRetrofit.InitRetrofit
import com.example.viewspecialties.listspecialties.model.ObjectResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object CacheDataRepository {

    suspend fun getDataEmployeesService() =
        CoroutineScope(Dispatchers.IO).async {
            var employees = InitRetrofit.getCurrentResult()
            //TODO Конкретно, дальше нужно отправить данные на сохранение в базу

            if(employees!= null){
                CacheRepository.updateCacheAsync(employees)
                return@async employees
            } else{
                Log.d("save to cache", "не могу сохранить данные в кэш они пустые")
            }
        }.await()

}

