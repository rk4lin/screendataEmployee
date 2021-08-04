package com.example.viewspecialties.cacheRepository

import com.example.viewspecialties.initRetrofit.InitRetrofit
import com.example.viewspecialties.modelService.Employee
import com.example.viewspecialties.modelService.ObjectResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

object CacheDataRepository {
    private var loadedData: ObjectResponse? = null

    fun requestData() =
        CoroutineScope(Dispatchers.IO).async {
            if(loadedData != null){
                return@async loadedData
            }

            var data = InitRetrofit.getObjectResponse()
            if (data != null) {
                loadedData = data
                 CacheRepository.insertData(data)
            }
            return@async data
        }

    fun returnData() : ObjectResponse{
        return loadedData!!
    }


}





