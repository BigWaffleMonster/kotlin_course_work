package com.example.app.api

import com.google.gson.annotations.SerializedName

data class EnrollResponse(
    val id: Int,
    val policy: Int,
    val year: Int,
    val month: Int,
    val day: Int,
    val time: String,
    val doctor_type: String
)

data class Enroll(
    @SerializedName("policy") val policy: Int,
    @SerializedName("year") val year: Int,
    @SerializedName("month") val month: Int,
    @SerializedName("day") val day: Int,
    @SerializedName("time") val time: String,
    @SerializedName("doctor_type") val doctor_type: String
)