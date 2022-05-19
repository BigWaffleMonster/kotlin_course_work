package com.example.app

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.api.ApiRepository
import com.example.app.databinding.ActivityListOfEnrollsBinding
import kotlinx.coroutines.launch

class ListOfEnrolls : AppCompatActivity() {
    lateinit var binding: ActivityListOfEnrollsBinding
    private val adapter = EnrollAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListOfEnrollsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        val btn = findViewById<Button>(R.id.getBtn)
        var enrollsFromApi = ArrayList<ArrayList<Any>>()

        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@ListOfEnrolls)
            rcView.adapter = adapter

            btn.setOnClickListener {
                enrollsFromApi = arrayListOf()
                val policy = findViewById<EditText>(R.id.policy)
                val inputPolicy = policy.text.toString().toInt()

                val req = ApiRepository()

                lifecycleScope.launch {
                    enrollsFromApi = req.getEnrolls(inputPolicy) as ArrayList<ArrayList<Any>>

//                    enrollsFromApi.forEach {
//                        el -> adapter.addEnroll(el)
//                        Log.d("qwe", "$el")
//                    }
                    adapter.addEnroll(enrollsFromApi)
                }

            }
        }
    }
}