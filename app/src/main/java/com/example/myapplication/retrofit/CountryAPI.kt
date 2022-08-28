package com.example.myapplication.retrofit

import com.example.myapplication.models.MainCountryDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryAPI {

    @GET("name/all")
    suspend fun getCountryDetails(): Response<List<MainCountryDetails>>
}