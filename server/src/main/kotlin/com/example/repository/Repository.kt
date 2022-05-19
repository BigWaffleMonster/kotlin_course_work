package com.example.repository

import com.example.repository.models.EnrollModel
import com.example.types.Enroll
import org.ktorm.database.Database
import org.ktorm.dsl.*

class Repository(private val db: Database) {
  fun addEnrollToDb(data: Enroll): String {
    db.insert(EnrollModel) {
      set(it.policy, data.policy)
      set(it.year, data.year)
      set(it.month, data.month)
      set(it.day, data.day)
      set(it.time, data.time)
      set(it.doctor_type, data.doctor_type)
    }

    return "ok"
  }

  fun getAllEnrolsByPolicy(policy: Int): ArrayList<Any> {
    val enrollArr = ArrayList<Any>()

    db
      .from(EnrollModel)
      .select()
      .where{ (EnrollModel.policy eq policy) }
      .forEach { row ->
        val id: Int? = row[EnrollModel.id]
        val rowPolicy: Int?= row[EnrollModel.policy]
        val year: Int?= row[EnrollModel.year]
        val month: Int? = row[EnrollModel.month]
        val day: Int? = row[EnrollModel.day]
        val time = row[EnrollModel.time]
        val doctor_type = row[EnrollModel.doctor_type]

        val qq = ArrayList<Any>()
        qq.add(id!!)
        qq.add(rowPolicy!!)
        qq.add(year!!)
        qq.add(month!!)
        qq.add(day!!)
        qq.add(time!!)
        qq.add(doctor_type!!)

        enrollArr.add(qq)
      }

    return enrollArr
  }

  fun removeEnroll(id: Int): Int {
    return db.delete(EnrollModel) { EnrollModel.id eq id }
  }
}