package com.example.viewspecialties.presentation.detailInfoEmployee.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.viewspecialties.databinding.FragmentDetailBinding
import com.example.viewspecialties.presentation.detailInfoEmployee.presenter.DetailInfoEmployeePresenter
import com.example.viewspecialties.modelService.Employee
import com.example.viewspecialties.modelService.Specialty

class DetailFragment : Fragment() {

   private lateinit var presenter: DetailInfoEmployeePresenter

   private var employee = mutableListOf<Employee>()
    //private lateinit var adapter:

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = DetailInfoEmployeePresenter()
        presenter.refresh()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

        }

    }
    fun getDataDetailEmployee(data: MutableList<Employee>){

    }

    companion object{
        var NAME_EMPLOYEE_KEY = "employee_name"
    }


}