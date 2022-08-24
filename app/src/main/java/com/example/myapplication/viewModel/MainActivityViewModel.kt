package com.example.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.MainCountryDetails
import com.example.myapplication.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(val repository: CountryRepository) : ViewModel() {


    val _country = MutableLiveData<List<MainCountryDetails>>()
    val country: LiveData<List<MainCountryDetails>> get() = _country

    init {
        getCountries()
    }

    private fun getCountries() {

        viewModelScope.launch {
            repository.getCountries().let {
                response ->
                if (response.isSuccessful ){
                    _country.postValue(response.body())
                }else{
                    Log.d("ApiError", "getCountries: ")
                }
            }
        }
    }
}