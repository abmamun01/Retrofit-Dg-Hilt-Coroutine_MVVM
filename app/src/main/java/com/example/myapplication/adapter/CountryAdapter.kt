package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.MainCountryDetails

class CountryAdapter(var context: Context, var countryDetails: List<MainCountryDetails>) :
    RecyclerView.Adapter<CountryAdapter.CountryHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)
        return CountryHolder(view)
    }


    override fun onBindViewHolder(holder: CountryHolder, position: Int) {

        holder.cName.text = countryDetails.get(position).name.toString()
        holder.cRegion.text = countryDetails.get(position).region
        holder.cCapital.text = countryDetails.get(position).capital.toString()
        holder.cLanguage.text = countryDetails.get(position).languages.toString()
        if (countryDetails.get(position).postalCode != null) {
            holder.cPostalCode.text = countryDetails.get(position).postalCode.toString()
        }
        holder.cCurrency.text = countryDetails.get(position).currencies.toString()
        holder.cPopulation.text = countryDetails.get(position).population.toString()

    }

    override fun getItemCount(): Int {
        return countryDetails.size
    }


    class CountryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cName: TextView = itemView.findViewById(R.id.name)
        val cRegion: TextView = itemView.findViewById(R.id.region)
        val cCapital: TextView = itemView.findViewById(R.id.capital)
        val cLanguage: TextView = itemView.findViewById(R.id.language)
        val cPostalCode: TextView = itemView.findViewById(R.id.postCode)
        val cCurrency: TextView = itemView.findViewById(R.id.currencies)
        val cPopulation: TextView = itemView.findViewById(R.id.population)

    }

}