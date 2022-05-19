package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.app.api.ApiRepository
import com.example.app.api.Enroll
import com.example.app.api.RetrofitClient
import kotlinx.coroutines.launch

class TimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        var time = ""

        val bt = findViewById<Button>(R.id.button)
        val bt2 = findViewById<Button>(R.id.button2)
        val bt3 = findViewById<Button>(R.id.button3)
        val bt4 = findViewById<Button>(R.id.button4)
        val bt5 = findViewById<Button>(R.id.button5)

        bt.setOnClickListener {
            time = "14:00"
            Toast.makeText(this, time, Toast.LENGTH_SHORT).show()
        }

        bt2.setOnClickListener {
            time = "14:15"
            Toast.makeText(this, time, Toast.LENGTH_SHORT).show()
        }

        bt3.setOnClickListener {
            time = "14:30"
            Toast.makeText(this, time, Toast.LENGTH_SHORT).show()
        }

        bt4.setOnClickListener {
            time = "14:45"
            Toast.makeText(this, time, Toast.LENGTH_SHORT).show()
        }

        bt5.setOnClickListener {
            if (time == "") {
                Toast.makeText(this, "Выберите время", Toast.LENGTH_SHORT).show()
            } else {
                var year = intent.getIntExtra("Year", 0)
                var month = intent.getIntExtra("Month", 0)
                var day = intent.getIntExtra("Day", 0)
                var policy = intent.getStringExtra("Input")
                var doctor = intent.getStringExtra("Doctor")
                Toast.makeText(this, "${year} ${month} ${day} ${policy} ${doctor}", Toast.LENGTH_SHORT).show()

                val req = ApiRepository()
                val enroll = Enroll(
                    policy = policy!!.toInt(),
                    year = year,
                    month = month,
                    day = day,
                    time = time,
                    doctor_type = doctor!!
                )

                lifecycleScope.launch {
                    req.postEnroll(enroll)
                }

                val intent = Intent(this, MainActivity::class.java)

                startActivity(intent)
            }
        }
    }
}