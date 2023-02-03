package com.cheezycode.randomquote.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheezycode.randomquote.models.AppointmentList
import com.cheezycode.randomquote.models.QuoteList
import com.cheezycode.randomquote.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            //repository.getQuotes(1)
            repository.getAppointments("D202301103")
        }
    }

    val appointments : LiveData<AppointmentList>
    get() = repository.appointments
}