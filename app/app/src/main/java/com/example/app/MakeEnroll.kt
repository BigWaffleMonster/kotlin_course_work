package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import kotlin.reflect.typeOf

class MakeEnroll : AppCompatActivity() {
    companion object {
        var year: Int = 0
        var month: Int = 0
        var day: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_enroll)

        val btn = findViewById<Button>(R.id.goto_time)
        val cl = findViewById<CalendarView>(R.id.calendarView)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val input = findViewById<EditText>(R.id.input)

        ArrayAdapter.createFromResource(
            this,
            R.array.doctors_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        cl.setOnDateChangeListener { cl, y, m, d ->
            year = y
            month = m + 1
            day = d
        }

        btn.setOnClickListener {
            if (year == 0 && month == 0 && day == 0) {
                Toast.makeText(this, "Выберите дату", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "$year $month $day", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, TimeActivity::class.java).apply {
                    putExtra("Year", year)
                    putExtra("Month", month)
                    putExtra("Day", day)
                    putExtra("Input", input.text.toString())
                    putExtra("Doctor", spinner.selectedItem.toString())
                }

                startActivity(intent)
            }
        }
    }
}