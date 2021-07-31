package com.example.viewspecialties.presentation.listspecialties.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewspecialties.BaseFragment
import com.example.viewspecialties.IBaseView
import com.example.viewspecialties.ISpecialtyView
import com.example.viewspecialties.R

import com.example.viewspecialties.databinding.FragmentListSpecialtiesBinding
import com.example.viewspecialties.modelService.Specialty
import com.example.viewspecialties.presentation.listEmployees.view.ListEmployeesFragment
import com.example.viewspecialties.presentation.listspecialties.presenter.ListSpecialtiesPresenter

class ListSpecialtiesFragment : BaseFragment(), ISpecialtyView {


    private lateinit var presenter: ListSpecialtiesPresenter
    private lateinit var adapter: SpecialtyListAdapter

    private var _binding: FragmentListSpecialtiesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = getPresenter(ListSpecialtiesPresenter::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListSpecialtiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SpecialtyListAdapter()

        binding.apply {
            specialtyList.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            specialtyList.adapter = adapter
        }

        adapter.initClick(object : OnItemClick {
            override fun onClicked(id: Int) {
                navigateToEployeeList(id)
            }

        })

    }

    override fun getDataSpecialty(data: MutableList<Specialty>) {
        adapter.setDataSpecialty(data)

    }

    private fun navigateToEployeeList(specialtyId: Int) {
        var bundle = Bundle()
        if (specialtyId != 0) {
            bundle.putInt(ListEmployeesFragment.KEY_ID_SPECIALTY, specialtyId)
            findNavController().navigate(
                R.id.action_listSpecialtiesFragment_to_listEmployeesFragment,
                bundle
            )
        }

        else{
            //TODO месадж об не возможности перехода
        }
    }


}