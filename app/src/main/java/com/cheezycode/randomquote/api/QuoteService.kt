package com.cheezycode.randomquote.api

import com.cheezycode.randomquote.models.AppointmentList
import com.cheezycode.randomquote.models.QuoteList
import retrofit2.Response
import retrofit2.http.*

interface QuoteService {

    /*@GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int) : Response<QuoteList>*/

    @FormUrlEncoded
    @POST("appointments.php")
    suspend fun getAppointments(@Field("doctorID") doctorID: String) : Response<AppointmentList>

}