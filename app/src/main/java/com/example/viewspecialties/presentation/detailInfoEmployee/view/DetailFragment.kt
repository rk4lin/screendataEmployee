package com.example.viewspecialties.presentation.detailInfoEmployee.view

import android.accounts.AccountManager.get
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ProcessLifecycleOwner.get
import com.example.viewspecialties.BaseFragment
import com.example.viewspecialties.databinding.FragmentDetailBinding
import com.example.viewspecialties.presentation.detailInfoEmployee.presenter.DetailInfoEmployeePresenter
import com.example.viewspecialties.presentation.detailInfoEmployee.model.EmployeeDetail
import com.example.viewspecialties.presentation.listEmployees.view.ListEmployeesFragment
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.logging.SimpleFormatter


class DetailFragment : BaseFragment(), IDetailFragment {

    private lateinit var presenter: DetailInfoEmployeePresenter

    private var nameEmployee: String? = null
    private var sournameEmployee: String? = null

    private var specialty: String? = null

    private var detail: EmployeeDetail? = null
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = getPresenter(DetailInfoEmployeePresenter::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        nameEmployee = arguments?.getString(NAME_EMPLOYEE_KEY)
        sournameEmployee = arguments?.getString(SOURNAME_EMPLOYEE_KEY)
        specialty = this.arguments?.getString(SPECIALTY_NAME_KEY)

        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        detail =  presenter.getDetailInfo()
        updateView(detail!!)
    }
    override fun getTriple(): Triple<String?, String?, String?> {
        return Triple(nameEmployee, sournameEmployee, specialty)

    }

    override fun updateView(emplDetal: EmployeeDetail) {

        binding.apply {
            Picasso.get().load(emplDetal.ava_url).into(avaUrl)
            name.text = emplDetal.f_name
            sourname.text = emplDetal.l_name
            age.text = emplDetal.age
            birthday.text = SimpleDateFormat("dd.MM.yyyy").format(SimpleDateFormat("yyyy-MM-dd").parse(emplDetal.birthday))
            specialtyName.text = emplDetal.specialty

        }
    }

     companion object {
        var NAME_EMPLOYEE_KEY = "employee_name"
        var SOURNAME_EMPLOYEE_KEY = "employee_sourname"
        var SPECIALTY_NAME_KEY = "specialty"
    }


}