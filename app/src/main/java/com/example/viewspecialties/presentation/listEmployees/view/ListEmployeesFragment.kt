package com.example.viewspecialties.presentation.listEmployees.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewspecialties.BaseFragment
import com.example.viewspecialties.R
import com.example.viewspecialties.databinding.FragmentListEmployeesBinding
import com.example.viewspecialties.presentation.detailInfoEmployee.model.EmployeeLocal
import com.example.viewspecialties.presentation.detailInfoEmployee.view.DetailFragment
import com.example.viewspecialties.presentation.listEmployees.presenter.ListEmployeesPresenter

class ListEmployeesFragment : BaseFragment(), IListEmployeeFragment {

   private var _binding: FragmentListEmployeesBinding? = null
    private val binding get() = _binding!!
    private var specialtyId: Int? = null
    private lateinit var presenter: ListEmployeesPresenter

    private lateinit var adapter: EmployeeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = getPresenter(ListEmployeesPresenter::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        specialtyId = arguments?.getInt(KEY_ID_SPECIALTY)!!.toInt()
        _binding = FragmentListEmployeesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = EmployeeListAdapter()

        binding.apply {
            emplList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            emplList.adapter = adapter
        }

        adapter.initClick(object: OnEmployeeClick{
            override fun onClicked(name: String) {
                navigateToDetailEmployee(name)
            }
        })

    }

   fun navigateToDetailEmployee(name: String){
       var bundle = Bundle()
       if(!name.isNullOrBlank()){
       bundle.putString(DetailFragment.NAME_EMPLOYEE_KEY, name)

       findNavController().navigate(R.id.action_listEmployeesFragment_to_detailFragment, bundle)
       }else{
           //TODO месадж о том что не могу перейти на другой экран
       }
   }
    override fun getSpecialtyId() : Int?{
        return specialtyId
    }

    override fun showEmployeeList(employeeModel: MutableList<EmployeeLocal>) {
        adapter.setData(employeeModel)
    }

    companion object{
        const val KEY_ID_SPECIALTY = "specialty_id"
    }

}