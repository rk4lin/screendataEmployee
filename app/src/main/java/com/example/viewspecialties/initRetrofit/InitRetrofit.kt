package com.example.viewspecialties.initRetrofit

import com.example.viewspecialties.GitLabApi
import com.example.viewspecialties.modelService.ObjectResponse
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InitRetrofit {

    private fun getRetrofit(): Retrofit {

        var BASE_URL = "http://gitlab.65apps.com/65gb/static/raw/master/"

        var interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        var okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val gson = GsonBuilder().create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()



        return retrofit
    }


     suspend fun getObjectResponse() : ObjectResponse?{

        var retrofit = getRetrofit()
        var service = retrofit.create(GitLabApi::class.java)

        var result = service.getListEmployees().await()

         if(result.isSuccessful) {
             return result.body()
        }
        else{
            return null
        }

    }

   }

