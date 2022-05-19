package com.example.repository

import org.ktorm.database.Database

class Database {
  fun connect(): Database {
    return Database.connect(
      url = "jdbc:postgresql://localhost:5436/",
      driver = "org.postgresql.Driver",
      user = "postgres",
      password = "qwerty"
    )
  }
}