package com.moonlightsplitter.cekongkir.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.moonlightsplitter.cekongkir.databinding.AdapterCityBinding
import com.moonlightsplitter.cekongkir.models.ResultsCity

class CityAdapter(
    val listCity: ArrayList<ResultsCity>,
    val listener: OnAdapterListener
): RecyclerView.Adapter<CityAdapter.ViewHolder>(), Filterable {

    private var citiesFilter = ArrayList<ResultsCity>()

    init {
        citiesFilter = listCity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        AdapterCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CityAdapter.ViewHolder, position: Int) {
        val city = citiesFilter[position]
        holder.binding.name.text = city.city_name
        holder.binding.container.setOnClickListener {
            listener.onClick(city)
        }
    }

    override fun getItemCount(): Int {
        return citiesFilter.size
    }

    class ViewHolder(val binding: AdapterCityBinding): RecyclerView.ViewHolder(binding.root)

    interface OnAdapterListener {
        fun onClick(result: ResultsCity)
    }

    fun setData(data: List<ResultsCity>) {
        listCity.clear()
        listCity.addAll(data)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charSearch = p0.toString()
                if (charSearch.isEmpty()) {
                    citiesFilter = listCity
                } else {
                    val citiesFiltered = ArrayList<ResultsCity>()
                    for (city in listCity) {
                        if (city.city_name.toLowerCase().contains(charSearch.toLowerCase())) {
                            citiesFiltered.add(city)
                        }
                    }
                    citiesFilter = citiesFiltered
                }
                val citiesFilteredResult = FilterResults()
                citiesFilteredResult.values = citiesFilter
                return citiesFilteredResult
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                citiesFilter = p1?.values as ArrayList<ResultsCity>
                notifyDataSetChanged()
            }
        }
    }
}