package com.example.viewspecialties.database

import android.app.Application
import android.content.Context

class AppSpecialty : Application() {

   init{
       instance = this
   }

    companion object{
        private var instance : AppSpecialty? = null

        fun getContext() : Context {
            return instance!!.applicationContext
        }
    }

}