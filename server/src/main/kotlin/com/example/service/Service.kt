package com.example.service

import com.example.repository.Repository
import com.example.types.Enroll

class Service(private val repository: Repository) {
  fun createEnroll(data: Enroll): String {
    return this.repository.addEnrollToDb(data)
  }

  fun getAllEnrolls(policy: Int): ArrayList<Any> {
    return this.repository.getAllEnrolsByPolicy(policy)
  }

  fun removeEnroll(id: Int): Int {
    return this.repository.removeEnroll(id)
  }
}