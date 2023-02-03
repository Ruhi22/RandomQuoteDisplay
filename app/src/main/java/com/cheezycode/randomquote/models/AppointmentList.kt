package com.cheezycode.randomquote.models

data class AppointmentList(
    val `data`: List<Data>,
    val message: String,
    val status: Int
)