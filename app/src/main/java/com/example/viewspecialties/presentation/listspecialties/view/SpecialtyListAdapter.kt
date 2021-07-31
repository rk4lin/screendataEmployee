package com.example.viewspecialties.presentation.listspecialties.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewspecialties.R
import com.example.viewspecialties.modelService.Specialty

interface OnItemClick {
    fun onClicked(id: Int)
}

class SpecialtyListAdapter : RecyclerView.Adapter<SpecialtyViewHolder>() {

    private var clickHandler: OnItemClick? = null

    var specialtyLocallist = mutableListOf<Specialty>()

    fun initClick(handler: OnItemClick) {
        clickHandler = handler
    }

    fun setDataSpecialty(items: List<Specialty>) {

        specialtyLocallist.clear()
        specialtyLocallist.addAll(items)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtyViewHolder {
        return SpecialtyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cell_sepcialty, parent, false),
            clickHandler
        )
    }

    override fun onBindViewHolder(holder: SpecialtyViewHolder, position: Int) {

        holder.bind(specialtyLocallist[position])

    }

    override fun getItemCount(): Int {
        return specialtyLocallist.size
    }
}