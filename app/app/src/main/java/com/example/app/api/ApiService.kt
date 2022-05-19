package com.example.app.api

import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("enroll")
    suspend fun postEnroll(@Body userData: Enroll): String

    @GET("enroll/{policy}")
    suspend fun getEnrolls(@Path("policy") policy: Int): ArrayList<Any>

    @DELETE("enroll/{enroll_id}")
    suspend fun deleteEnroll(@Path("enroll_id") enroll_id: Int): Any
}