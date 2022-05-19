package com.example.app.api

import retrofit2.Response

class ApiRepository {
    suspend fun postEnroll(userData: Enroll): String {
        return RetrofitClient.api.postEnroll(userData)
    }

    suspend fun getEnrolls(policy: Int): ArrayList<Any> {
        return RetrofitClient.api.getEnrolls(policy)
    }

    suspend fun deleteEnroll(enroll_id: Int): Any {
        return RetrofitClient.api.deleteEnroll(enroll_id)
    }
}