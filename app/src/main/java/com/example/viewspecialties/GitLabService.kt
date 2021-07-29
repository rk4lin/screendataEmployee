package com.example.viewspecialties



import com.example.viewspecialties.modelService.ObjectResponse

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface GitLabApi {
    @GET("./testTask.json")
   fun getListEmployees() : Deferred<Response<ObjectResponse>>

}