package com.example.myapplication.repository

import com.example.myapplication.retrofit.CountryAPI
import javax.inject.Inject

class CountryRepository @Inject constructor(val api: CountryAPI) {

    suspend fun getCountries() = api.getCountryDetails()



    fun getSearchedCountryDetails(query:String){

    }
}