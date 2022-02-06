package com.moonlightsplitter.cekongkir.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moonlightsplitter.cekongkir.databinding.AdapterSubdistrictBinding
import com.moonlightsplitter.cekongkir.models.ResultsSubdistrict

class SubdistrictAdapter(
    val listSubdistrict: ArrayList<ResultsSubdistrict>,
    val listener: OnAdapterListener
): RecyclerView.Adapter<SubdistrictAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder (
        AdapterSubdistrictBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: SubdistrictAdapter.ViewHolder, position: Int) {
        val subdistrict = listSubdistrict[position]
        holder.binding.name.text = subdistrict.subdistrict_name
        holder.binding.container.setOnClickListener {
            listener.onClick(subdistrict)
        }
    }

    override fun getItemCount(): Int {
        return listSubdistrict.size
    }

    class ViewHolder(val binding: AdapterSubdistrictBinding): RecyclerView.ViewHolder(binding.root)

    interface OnAdapterListener {
        fun onClick(result: ResultsSubdistrict)
    }

    fun setData(data: List<ResultsSubdistrict>) {
        listSubdistrict.clear()
        listSubdistrict.addAll(data)
        notifyDataSetChanged()
    }
}