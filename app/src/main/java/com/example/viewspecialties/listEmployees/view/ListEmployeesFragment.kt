package com.example.viewspecialties.listEmployees.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewspecialties.R
import com.example.viewspecialties.databinding.FragmentListEmployeesBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListEmployeesFragment : Fragment() {

   private var _binding: FragmentListEmployeesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListEmployeesBinding.inflate(inflater, container, false)
        return binding.root
    }

}