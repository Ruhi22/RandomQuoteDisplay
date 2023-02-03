package com.cheezycode.randomquote.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cheezycode.randomquote.api.QuoteService
import com.cheezycode.randomquote.db.QuoteDatabase
import com.cheezycode.randomquote.models.AppointmentList
import com.cheezycode.randomquote.models.QuoteList
import com.cheezycode.randomquote.utils.NetworkUtils

class QuoteRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    //private val quotesLiveData = MutableLiveData<QuoteList>()
    private val appointmentsLiveData = MutableLiveData<AppointmentList>()

    /*val quotes: LiveData<QuoteList>
    get() = quotesLiveData*/
    val appointments: LiveData<AppointmentList>
    get() = appointmentsLiveData

    /*suspend fun getQuotes(page: Int){

        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = quoteService.getQuotes(page)
            if(result?.body() != null){
                quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
                quotesLiveData.postValue(result.body())
            }
        }
        else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1,1,1,quotes, 1, 1)
            quotesLiveData.postValue(quoteList)
        }

    }*/

    suspend fun getAppointments(doctorID: String){

        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = quoteService.getAppointments(doctorID)
            if(result?.body() != null){
                quoteDatabase.quoteDao().addAppointments(result.body()!!.data)
                appointmentsLiveData.postValue(result.body())
            }
        }
        else{
            val appointments = quoteDatabase.quoteDao().getAppointments()
            val appointmentList = AppointmentList(appointments,"Appointments available.",1)
            appointmentsLiveData.postValue(appointmentList)
        }

    }
}







