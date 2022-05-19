package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.app.api.ApiRepository
import com.example.app.api.RetrofitClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.to_add_enroll_view)
        val btn2 = findViewById<Button>(R.id.to_get_enroll_view)

        btn.setOnClickListener {
            val intent = Intent(this, MakeEnroll::class.java)

            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this, ListOfEnrolls::class.java)

            startActivity(intent)
        }
    }
}