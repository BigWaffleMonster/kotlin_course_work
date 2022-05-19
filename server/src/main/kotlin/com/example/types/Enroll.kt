package com.example.types

import com.google.gson.annotations.SerializedName

data class Enroll(
  @SerializedName("policy") val policy: Int,
  @SerializedName("year") val year: Int,
  @SerializedName("month") val month: Int,
  @SerializedName("day") val day: Int,
  @SerializedName("time") val time: String,
  @SerializedName("doctor_type") val doctor_type: String
)
