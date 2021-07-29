package com.example.viewspecialties.presentation.listspecialties.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewspecialties.IBaseView
import com.example.viewspecialties.databinding.FragmentListSpecialtiesBinding
import com.example.viewspecialties.modelService.Specialty
import com.example.viewspecialties.presentation.listspecialties.presenter.ListSpecialtiesPresenter

class ListSpecialtiesFragment : Fragment(), IBaseView {

    private var presenter= ListSpecialtiesPresenter()
    private lateinit var adapter: SpecialtyListAdapter

    private var _binding: FragmentListSpecialtiesBinding? = null
    private val binding get() = _binding!!

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

   }

    override fun onAttach(context: Context) {
        super.onAttach(context)
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
            specialtyList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            specialtyList.adapter = adapter
        }
    }

    override fun getDataSpecialty(data: MutableList<Specialty>) {
        adapter.setDataSpecialty(data)

    }


}