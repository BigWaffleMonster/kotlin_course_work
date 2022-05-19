package com.example.handler

import com.example.service.Service
import com.example.types.Enroll

class Handler(private val service: Service) {

  fun createEnroll(data: Enroll): String {
    return this.service.createEnroll(data)
  }

  fun getAllEnrolls(policy: Int): ArrayList<Any> {
    return this.service.getAllEnrolls(policy)
  }

  fun removeEnroll(id: Int): Int {
    return this.service.removeEnroll(id)
  }

}