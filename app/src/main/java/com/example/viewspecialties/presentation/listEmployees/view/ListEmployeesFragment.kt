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
    private var specialtyName: String? = null
    private lateinit var presenter: ListEmployeesPresenter

    private lateinit var adapter: EmployeeListAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = getPresenter(ListEmployeesPresenter::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        specialtyId = arguments?.getInt(KEY_ID_SPECIALTY)!!.toInt()
        specialtyName = arguments?.getString(SPECIALTY_KEY)
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
            override fun onClicked(name: String, sourname: String) {
                navigateToDetailEmployee(name,sourname, specialtyName!!)
            }
        })

    }

   fun navigateToDetailEmployee(name: String, sourname: String, specialtyName: String){
       var bundle = Bundle()
       if(!name.isNullOrBlank()){
       bundle.putString(DetailFragment.NAME_EMPLOYEE_KEY, name)
       bundle.putString(DetailFragment.SOURNAME_EMPLOYEE_KEY, sourname)
       bundle.putString(DetailFragment.SPECIALTY_NAME_KEY, specialtyName)

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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    companion object{
        const val KEY_ID_SPECIALTY = "specialty_id"
        const val SPECIALTY_KEY="spec"
    }

}