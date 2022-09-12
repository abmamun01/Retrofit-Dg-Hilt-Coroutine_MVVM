package com.example.myapplication.repository

import com.example.myapplication.retrofit.CountryAPI
import javax.inject.Inject

class CountryRepository @Inject constructor(val api: CountryAPI) {

    suspend fun getCountries(search: String) =
        api.getCountryDetails(search)


    fun getSearchedCountryDetails(query: String) {

    }
}