package com.example.viewspecialties

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.viewspecialties.presentation.listspecialties.view.EmployeeListAdapter
import retrofit2.*


class MainActivity : AppCompatActivity() {


    lateinit var employeeListAdapter: EmployeeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


}