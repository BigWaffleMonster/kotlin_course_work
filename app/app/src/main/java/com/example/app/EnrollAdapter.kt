package com.example.app

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.app.api.ApiRepository
import com.example.app.databinding.EnrollElementBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class EnrollAdapter: RecyclerView.Adapter<EnrollAdapter.EnrollAdapterHolder>() {
    var enrollList = ArrayList<ArrayList<Any>>()

    class EnrollAdapterHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = EnrollElementBinding.bind(item)
        fun bind(enroll: ArrayList<Any>) = with(binding){
            var qqq = enroll[4].toString()
            var qq = qqq.split(".")
            var day = qq[0].toInt()

            var www = enroll[3].toString()
            var ww = www.split(".")
            var month = ww[0].toInt()

            var eee = enroll[2].toString()
            var ee = eee.split(".")
            var year = ee[0].toInt()

            doctor.text = enroll[6].toString()
            dateTime.text = "${day}.${month}.${year} ${enroll[5]}"

            delete.setOnClickListener {
                val req = ApiRepository()

                var idq = enroll[0].toString()
                var q = idq.split(".")
                var id = q[0].toInt()

                GlobalScope.launch { req.deleteEnroll(enroll_id = id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnrollAdapterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.enroll_element, parent, false)
        return EnrollAdapterHolder(view)
    }

    override fun onBindViewHolder(holder: EnrollAdapterHolder, position: Int) {
        holder.bind(enrollList[position])
    }

    override fun getItemCount(): Int {
        return enrollList.size
    }

    fun addEnroll(enroll: ArrayList<ArrayList<Any>>) {
            enrollList = enroll
            notifyDataSetChanged()
    }
}