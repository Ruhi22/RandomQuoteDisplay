package com.cheezycode.randomquote.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appointment")
data class Data(
    val DOB: String,
    val Name: String,
    val addressLine1: String,
    val addressLine2: String,
    val quoteId: Int,
    @PrimaryKey
    val appointmentID: String,
    val blood: String,
    val charges: String,
    val city: String,
    val date: String,
    val day: String,
    val doctorID: String,
    val doctorToken: String,
    val dueDate: String,
    val fee: String,
    val firstname: String,
    val hospitalID: String,
    val lastname: String,
    val paid_status: String,
    val patientID: String,
    val patientImage: String,
    val payment_method: String,
    val phoneNumber: String,
    val pincode: String,
    val state: String,
    val status: String,
    val time: String,
    val week: String
)