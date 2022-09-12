package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.CountryAdapter
import com.example.myapplication.viewModel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CountryAdapter
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var rcView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rcView = findViewById(R.id.recyclerViewID)


        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getCountries("united")


        viewModel.country.observe(this, Observer { response ->
            rcView.layoutManager = LinearLayoutManager(this)
            adapter = CountryAdapter(this, response)
            rcView.adapter = adapter

        })
    }
}