package com.example.viewspecialties.database

import android.app.Application
import android.content.Context

class AppSpecialty : Application() {

    companion object{
        private val instance : AppSpecialty? = null

        fun getContext() : Context {

            return instance!!.applicationContext
        }
    }

}