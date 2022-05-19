package com.example.repository.models

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object EnrollModel: Table<Nothing>("enroll") {
  val id = int("id").primaryKey()
  val policy = int("policy")
  val year = int("year")
  val month = int("month")
  val day = int("day")
  val time = varchar("time")
  val doctor_type = varchar("doctor_type")
}