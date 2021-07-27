package com.example.viewspecialties.cacheRepository

import com.example.viewspecialties.initRetrofit.InitRetrofit
import com.example.viewspecialties.presentation.listspecialties.model.ObjectResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

object CacheDataRepository {
    private var loadedData: ObjectResponse? = null

    /*suspend fun getDataEmployeesService() =
        CoroutineScope(Dispatchers.IO).async {
            var employees = InitRetrofit.getCurrentResult()
            //TODO Конкретно, дальше нужно отправить данные на сохранение в базу

            if(employees!= null){
                CacheRepository.updateCacheAsync(employees)
                return@async employees
            } else{
                Log.d("save to cache", "не могу сохранить данные в кэш они пустые")
            }
        }.await()*/

     fun requestData() =

        CoroutineScope(Dispatchers.IO).async {
        var data = InitRetrofit.getObjectResponse()
            if(data!= null) {
                loadedData = data
                CacheRepository.insertData(data)
            }
            return@async data
            }


}





