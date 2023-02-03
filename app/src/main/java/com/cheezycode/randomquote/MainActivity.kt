package com.cheezycode.randomquote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cheezycode.randomquote.adapter.AppointmentAdapter
import com.cheezycode.randomquote.api.QuoteService
import com.cheezycode.randomquote.api.RetrofitHelper
import com.cheezycode.randomquote.models.Data
import com.cheezycode.randomquote.repository.QuoteRepository
import com.cheezycode.randomquote.viewmodels.MainViewModel
import com.cheezycode.randomquote.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var rv_appointmentList: RecyclerView
    var appointments: List<Data> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).quoteRepository

        rv_appointmentList = findViewById(R.id.rv_appointmentList)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.appointments.observe(this, Observer {
            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
            appointments = it.data
            // this creates a vertical layout Manager
            rv_appointmentList.layoutManager = LinearLayoutManager(this)

            // ArrayList of class ItemsViewModel
            //val data = ArrayList<Data>()

            // This will pass the ArrayList to our Adapter
            val adapter = AppointmentAdapter(appointments, applicationContext)

            // Setting the Adapter with the recyclerview
            rv_appointmentList.adapter = adapter
        })



    }
}